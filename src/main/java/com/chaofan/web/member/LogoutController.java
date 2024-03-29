package com.chaofan.web.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chaofan.utils.ShiroUtils;

@Controller
public class LogoutController {

	/**
	 * 注销
	 */
	@RequestMapping(value = "logout.html", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		if (session.getAttribute("currMember") != null) {
			session.removeAttribute("currMember");
			ShiroUtils.logout();
		}
		return "redirect:/";
	}
	
}
