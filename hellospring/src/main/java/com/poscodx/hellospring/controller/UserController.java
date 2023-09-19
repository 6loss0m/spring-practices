package com.poscodx.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poscodx.hellospring.vo.UserVo;

/*
 * @RequestMapping 클래스 + 메서드 매핑
 * 
 * 강추
 */
@RequestMapping("/user")
@Controller
public class UserController {

//	@RequestMapping("/joinform")
//	public String joinform() {
//		return "/WEB-INF/views/joinform.jsp";
//	}

	@RequestMapping(value = "/joinform", method = RequestMethod.GET)
	public String joinform() {
		return "/WEB-INF/views/joinform.jsp";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVo userVo) {
		System.out.println("UserController.join() : USerDao.insert(" + userVo + ")");
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		/*
		 * 만약 n이라는 이름의 URL 파라미터가 없으면
		 * 400 bad request 에러 발생. 
		 */
		return "UserController.update(" + name + ")";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required = true, defaultValue = "") String name) {
		return "UserController.update(" + name + ")";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public String list(@RequestParam(value="p", required = true, defaultValue = "1") int pageNo) {
		return "UserController.update(" + pageNo + ")";
	}
}
