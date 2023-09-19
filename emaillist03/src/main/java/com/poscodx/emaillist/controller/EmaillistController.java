package com.poscodx.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poscodx.emaillist.repository.EmaillistRepository;
import com.poscodx.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {

	@Autowired // @Autowired = DI 주입, repository에 해당 객체(bean)가 있으면 injection 해달라.
	private EmaillistRepository emaillistRepository;

	@RequestMapping("/")
	public String main(Model model) {
		List<EmaillistVo> list = emaillistRepository.findAll();
		model.addAttribute("list", list);
		return "main";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(EmaillistVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";
	}

}
