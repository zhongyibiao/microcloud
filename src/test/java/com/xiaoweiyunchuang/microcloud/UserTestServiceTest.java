package com.xiaoweiyunchuang.microcloud;

import java.math.BigDecimal;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.xiaoweiyunchuang.microcloud.domain.UserTest;
import com.xiaoweiyunchuang.microcloud.service.UserTestService;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class UserTestServiceTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserTestService userService;

	@Test
	public void saveUser() {
		UserTest user = new UserTest();
		user.setName("zhongyibiao");
		user.setAge(18);
		user.setPassword("12345678");
		user.setSalary(new BigDecimal("6789"));
		userService.saveUser(user);
	}

	@Test
	public void updateUser() {
		UserTest user = new UserTest();
		user.setId(21);
		user.setName("zhongyibiao");
		user.setAge(18);
		user.setPassword("12345678");
		user.setSalary(new BigDecimal("3789"));
		userService.updateUser(user);
	}

	@Test
	public void findUserById() {
		UserTest user = userService.findUserById(21);
		Assert.notNull(user);
	}

	@Test
	public void deleteUserById() {
		userService.deleteUserById(21);
		UserTest user = userService.findUserById(21);
		Assert.isNull(user);
	}

}
