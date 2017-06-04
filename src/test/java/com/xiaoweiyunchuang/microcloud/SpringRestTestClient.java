package com.xiaoweiyunchuang.microcloud;

import java.math.BigDecimal;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.xiaoweiyunchuang.microcloud.domain.UserTest;

public class SpringRestTestClient {

	public Logger logger = LoggerFactory.getLogger(this.getClass());
	public static final String REST_SERVICE_URI = "http://localhost:8080";

	/* GET */
	@SuppressWarnings("unchecked")
	@Test
	public void listAllUsers() {
		logger.info("Testing listAllUsers API-----------");

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI + "/user/",
				List.class);

		if (usersMap != null) {
			for (LinkedHashMap<String, Object> map : usersMap) {
				logger.info("User : id=" + map.get("id") + ", Name=" + map.get("name") + ", Age=" + map.get("age")
						+ ", Salary=" + map.get("salary"));
				;
			}
		} else {
			logger.info("No user exist----------");
		}
	}

	/* GET */
	@Test
	public void getUser() {
		logger.info("Testing getUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		UserTest user = restTemplate.getForObject(REST_SERVICE_URI + "/user/1", UserTest.class);
		logger.info(user.toString());
	}

	/* POST */
	@Test
	public void createUser() {
		logger.info("Testing create User API----------");
		RestTemplate restTemplate = new RestTemplate();
		UserTest user = new UserTest(0, "Sarah", 51, new BigDecimal("1344"), "123456789");
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/user/", user, UserTest.class);
		logger.info("Location : " + uri.toASCIIString());
	}

	/* PUT */
	@Test
	public void updateUser() {
		logger.info("Testing update User API----------");
		RestTemplate restTemplate = new RestTemplate();
		UserTest user = new UserTest(1, "Tomy", 33, new BigDecimal("2343"), "123456789");
		restTemplate.put(REST_SERVICE_URI + "/user/1", user);
		logger.info(user.toString());
	}

	/* DELETE */
	@Test
	public void deleteUser() {
		logger.info("Testing delete User API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/user/3");
	}

	/* DELETE */
	@Test
	public void deleteAllUsers() {
		logger.info("Testing all delete Users API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/user/");
	}
}