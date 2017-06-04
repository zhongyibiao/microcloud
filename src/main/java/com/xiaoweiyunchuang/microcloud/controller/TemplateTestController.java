package com.xiaoweiyunchuang.microcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateTestController {

	/**
	 * 
	 * 返回html模板.
	 * 
	 */
	@RequestMapping("/hello")
	public String helloHtml() {
		return "hello";
	}
}
