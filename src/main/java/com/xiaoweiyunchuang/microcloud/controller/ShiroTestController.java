package com.xiaoweiyunchuang.microcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShiroTestController extends AbstractController {
	/**
	 * shiro tag测试
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/shiro" })
	public String shiro() {
		return "shiro";
	}

}
