package com.adaptavant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AdaptavantController {

	@RequestMapping("/")
	public String re_directhome(HttpServletRequest request) {
		request.setAttribute("pageTitle", "MD AUTOMATIONS");
		return "homelayout";
	}
	
}
