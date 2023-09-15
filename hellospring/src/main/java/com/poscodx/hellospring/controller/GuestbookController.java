package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @ RequestMapping Class 단독 매핑
 * Spring MVC 4.x 에서만 지원 !
 */
//@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping	//Method의 이름으로 mapping
	public String list() {
		return "GuestbookController.list";
	}
	
	@ResponseBody
	@RequestMapping
	public String delete() {
		return "GuestbookController.delete";
	}
}
