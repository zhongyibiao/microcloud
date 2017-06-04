package com.xiaoweiyunchuang.microcloud.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoweiyunchuang.microcloud.domain.UserTest;
import com.xiaoweiyunchuang.microcloud.service.UserTestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "用户服务", description = "提供RESTful风格API的用户的增删改查服务")
@RestController
public class UserTestController extends AbstractController {

	@Autowired
	UserTestService userTestService;

	// -------------------Retrieve All------------------- //
	@ApiOperation("查询所有用户")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	//@RequiresPermissions("user:view")
	public ResponseEntity<List<UserTest>> listAllUsers() {
		List<UserTest> users = userTestService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<UserTest>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserTest>>(users, HttpStatus.OK);
	}

	// -------------------Retrieve Page------------------- //
	@ApiOperation("分页查询用户")
	@RequestMapping(value = " 	r/{pageNum}/{pageSize}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequiresPermissions("user:view")
	public PageInfo getUsers(@ApiParam("pageNum") @PathVariable Integer pageNum,
			@ApiParam("pageSize") @PathVariable Integer pageSize) {
		if (pageNum != null && pageSize != null) {
			PageHelper.startPage(pageNum, pageSize);
		}
		List<UserTest> users = userTestService.findAllUsers();

		return new PageInfo(users);
	}

	// -------------------Retrieve Single------------------- //
	@ApiOperation("通过id查询用户")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequiresPermissions("user:view")
	public ResponseEntity<UserTest> getUser(@ApiParam("用户id") @PathVariable("id") long id) {
		logger.info("Fetching User with id " + id);
		UserTest user = userTestService.findUserById(id);
		if (user == null) {
			logger.info("User with id " + id + " not found");
			return new ResponseEntity<UserTest>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserTest>(user, HttpStatus.OK);
	}

	// -------------------Create a------------------- //
	@ApiOperation("添加用户")
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	@RequiresPermissions("user:add")
	public ResponseEntity<Void> createUser(@ApiParam("用户信息") @RequestBody UserTest user,
			UriComponentsBuilder ucBuilder) {
		logger.info("Creating User " + user.getName());
		//
		if (userTestService.isUserExist(user.getName())) {
			logger.info("A User with name " + user.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		userTestService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a User------------------- //
	@ApiOperation("更新用户")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	@RequiresPermissions("user:update")
	public ResponseEntity<UserTest> updateUser(@ApiParam("用户id") @PathVariable("id") long id,
			@ApiParam("用户信息") @RequestBody UserTest user) {
		logger.info("Updating User " + id);

		UserTest currentUser = userTestService.findUserById(id);

		if (currentUser == null) {
			logger.info("User with id " + id + " not found");
			return new ResponseEntity<UserTest>(HttpStatus.NOT_FOUND);
		}

		currentUser.setName(user.getName());
		currentUser.setAge(user.getAge());
		currentUser.setSalary(user.getSalary());

		userTestService.updateUser(currentUser);
		return new ResponseEntity<UserTest>(currentUser, HttpStatus.OK);
	}

	// ------------------- Delete a User------------------- //
	@ApiOperation("通过ID删除用户")
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	@RequiresPermissions("user:delete")
	public ResponseEntity<UserTest> deleteUser(@ApiParam("用户id") @PathVariable("id") long id) {
		logger.info("Fetching & Deleting User with id " + id);

		UserTest user = userTestService.findUserById(id);
		if (user == null) {
			logger.info("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<UserTest>(HttpStatus.NOT_FOUND);
		}

		userTestService.deleteUserById(id);
		return new ResponseEntity<UserTest>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Users------------------- //
	@ApiOperation("删除所有用户")
	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	@RequiresPermissions("user:delete")
	public ResponseEntity<UserTest> deleteAllUsers() {
		logger.info("Deleting All Users");

		userTestService.deleteAllUsers();
		return new ResponseEntity<UserTest>(HttpStatus.NO_CONTENT);
	}

}