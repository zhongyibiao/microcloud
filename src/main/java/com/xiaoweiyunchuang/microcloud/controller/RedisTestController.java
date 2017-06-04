package com.xiaoweiyunchuang.microcloud.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoweiyunchuang.microcloud.domain.UserTest;

@RestController
class RedisTestController extends AbstractController {

	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Resource(name = "stringRedisTemplate")
	ValueOperations<String, String> valOpsStr;

	@Autowired
	RedisTemplate<Object, Object> redisTemplate;
	@Resource(name = "redisTemplate")
	ValueOperations<Object, Object> valOps;

	@RequestMapping(value = "set/{key}/{value}", method = RequestMethod.GET)
	public String setKeyAndValue(@PathVariable("key") String key, @PathVariable("value") String value) {
		// stringRedisTemplate.opsForValue().set(key, value);

		valOpsStr.set(key, value);
		return "Set Ok";
	}

    @RequestMapping(value = "get/{key}", method = RequestMethod.GET)
	public String getKey(@PathVariable("key") String key) {
		return valOpsStr.get(key);
		// return stringRedisTemplate.opsForValue().get(key);
	}

	//@RequestMapping(value = "/set/{phoneNum}", method = RequestMethod.GET)
	public String setSMSBean(@PathVariable("phoneNum") String phoneNum) {
		UserTest user = new UserTest();
		user.setName("zhongyb");
	    user.setPassword("123456");
		// redisTemplate.opsForValue().set(phoneNum, SMSBean);

		valOps.set(phoneNum, user);
		return "Set Ok";
	}

	//@RequestMapping(value = "/get/{phoneNum}", method = RequestMethod.GET)
	public ResponseEntity<UserTest> getSMSBean(@PathVariable("phoneNum") String phoneNum) {
		// SMSBean SMSBean = (SMSBean)
		// redisTemplate.opsForValue().get(phoneNum);
		UserTest user = (UserTest) valOps.get(phoneNum);
		return new ResponseEntity<UserTest>(user, HttpStatus.OK);
	}

}
