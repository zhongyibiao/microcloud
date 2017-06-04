package com.xiaoweiyunchuang.microcloud.controller;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.pagehelper.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "购物车服务", description = "购物车服务，提供增加删除查询服务API")
@RestController
public class ShoppingCartController extends AbstractController {
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Resource(name = "stringRedisTemplate")
	ValueOperations<String, String> valOpsStr;

	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@Resource(name = "redisTemplate")
	ValueOperations<String, String> valOps;
	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOps;
	@Resource(name = "redisTemplate")
	private SetOperations<String, String> setOps;
	@Resource(name = "redisTemplate")
	private ZSetOperations<String, String> zSetOps;

	/**
	 * 添加商品到购物车
	 * 
	 * @param itemId
	 * @param count
	 * @param openid
	 */
	@ApiOperation("添加物品")
	@RequestMapping(value = "/cart/{itemId}/{count}/{openid}", method = RequestMethod.POST)
	public ResponseEntity<Void> addToCart(@ApiParam("商品id") @PathVariable("itemId") String itemId,
			@ApiParam("商品数量") @PathVariable("count") Integer count,
			@ApiParam("微信用户标识") @PathVariable("openid") String openid, UriComponentsBuilder ucBuilder) {
		String shoppingcartkey = "";
		if (StringUtil.isEmpty(openid)) {
			Subject subject = SecurityUtils.getSubject();
			String username = subject.getPrincipal().toString();
			Serializable sessionId = subject.getSession().getId();
			shoppingcartkey = "shoppingcart:" + username + ":" + sessionId.toString();
		} else {
			shoppingcartkey = "shoppingcart:" + openid;
		}

		// boolean delta = zSetOps.add(shoppingcartkey, itemId, count);
		logger.info("addToCart shoppingcartkey=" + shoppingcartkey);

		double delta = zSetOps.incrementScore(shoppingcartkey, itemId, count);
		logger.info("addToCart delta=" + delta);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.OK);

	}

	/**
	 * 从购物车删除物品
	 * 
	 * @param itemId
	 * @param count
	 * @param openid
	 */
	@ApiOperation("删除物品")
	@RequestMapping(value = "/cart/{itemId}/{count}/{openid}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delToCart(@ApiParam("商品id") @PathVariable("itemId") String itemId,
			@ApiParam("商品数量") @PathVariable("count") Integer count,
			@ApiParam("微信用户标识") @PathVariable("openid") String openid, UriComponentsBuilder ucBuilder) {
		String shoppingcartkey = "";
		if (StringUtil.isEmpty(openid)) {
			Subject subject = SecurityUtils.getSubject();
			String username = subject.getPrincipal().toString();
			Serializable sessionId = subject.getSession().getId();
			shoppingcartkey = "shoppingcart:" + username + ":" + sessionId.toString();
		} else {
			shoppingcartkey = "shoppingcart:" + openid;
		}

		logger.info("delToCart shoppingcartkey=" + shoppingcartkey);
		double delta = zSetOps.incrementScore(shoppingcartkey, itemId, -count);
		if (delta < 1) {
			zSetOps.remove(shoppingcartkey, itemId);
		}
		logger.info("delToCart delta=" + delta);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

	/**
	 * 获取购物车物品
	 * 
	 * @param openid
	 */
	@ApiOperation("获取物品")
	@RequestMapping(value = "/cart/{openid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<ZSetOperations.TypedTuple<String>>> getCart(
			@ApiParam("微信用户标识") @PathVariable("openid") String openid) {
		String shoppingcartkey = "";
		if (StringUtil.isEmpty(openid)) {
			Subject subject = SecurityUtils.getSubject();
			String username = subject.getPrincipal().toString();
			Serializable sessionId = subject.getSession().getId();
			shoppingcartkey = "shoppingcart:" + username + ":" + sessionId.toString();
		} else {
			shoppingcartkey = "shoppingcart:" + openid;
		}

		logger.info("getCart shoppingcartkey=" + shoppingcartkey);
		Set<ZSetOperations.TypedTuple<String>> items = zSetOps.rangeWithScores(shoppingcartkey, 0, -1);

		for (ZSetOperations.TypedTuple item : items) {
			logger.info("Value=" + item.getValue() + " Score=" + item.getScore());
		}

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Set<ZSetOperations.TypedTuple<String>>>(items,
				(items.size() > 0) ? HttpStatus.OK : HttpStatus.NOT_FOUND);

	}

	/**
	 * 获取购物车物品
	 * 
	 * @param session
	 * @param item
	 * @param openid
	 */
	@ApiOperation("获取物品")
	@RequestMapping(value = "/cart/{itemId}/{openid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<ZSetOperations.TypedTuple<String>>> getCart(
			@ApiParam("商品id") @PathVariable("itemId") String itemId,
			@ApiParam("微信用户标识") @PathVariable("openid") String openid) {
		String shoppingcartkey = "";
		if (StringUtil.isEmpty(openid)) {
			Subject subject = SecurityUtils.getSubject();
			String username = subject.getPrincipal().toString();
			Serializable sessionId = subject.getSession().getId();
			shoppingcartkey = "shoppingcart:" + username + ":" + sessionId.toString();
		} else {
			shoppingcartkey = "shoppingcart:" + openid;
		}

		logger.info("getCart shoppingcartkey=" + shoppingcartkey);
		Set<ZSetOperations.TypedTuple<String>> items = zSetOps.rangeWithScores(shoppingcartkey, 0, -1);

		Set<ZSetOperations.TypedTuple<String>> resutlItems = new HashSet<ZSetOperations.TypedTuple<String>>();
		for (ZSetOperations.TypedTuple item : items) {
			logger.info("Value=" + item.getValue() + " Score=" + item.getScore());
			if (item.getValue().equals(itemId)) {
				resutlItems.add(item);
			}
		}

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Set<ZSetOperations.TypedTuple<String>>>(resutlItems,
				(resutlItems.size() > 0) ? HttpStatus.OK : HttpStatus.NOT_FOUND);

	}

	/**
	 * 清空购物车
	 * 
	 * @param openid
	 * 
	 */
	@ApiOperation("清空购物车")
	@RequestMapping(value = "/cart/{openid}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> clearCart(@ApiParam("商品id") @PathVariable("itemId") String itemId,
			@ApiParam("微信用户标识") @PathVariable("openid") String openid) {
		String shoppingcartkey = "";
		if (StringUtil.isEmpty(openid)) {
			Subject subject = SecurityUtils.getSubject();
			String username = subject.getPrincipal().toString();
			Serializable sessionId = subject.getSession().getId();
			shoppingcartkey = "shoppingcart:" + username + ":" + sessionId.toString();
		} else {
			shoppingcartkey = "shoppingcart:" + openid;
		}

		Set<ZSetOperations.TypedTuple<String>> items = zSetOps.rangeWithScores(shoppingcartkey, 0, -1);
		for (ZSetOperations.TypedTuple item : items) {
			zSetOps.remove(shoppingcartkey, item);
		}
		//zSetOps.removeRange("shoppingcartkey", 0, -1);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.OK);

	}

}
