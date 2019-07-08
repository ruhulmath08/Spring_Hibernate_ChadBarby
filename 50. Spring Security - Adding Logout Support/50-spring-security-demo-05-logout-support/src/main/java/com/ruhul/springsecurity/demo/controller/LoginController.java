package com.ruhul.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	// map with 'loginPage("/showMyLoginPage")' in "DemoSecurityConfig.class"
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {

		// "plain-login.jsp" page in "/WEB-INF/view/plain-login.jsp"
		return "fancy-login";
	}
}
