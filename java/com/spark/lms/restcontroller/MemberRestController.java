package com.spark.lms.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spark.lms.model.Member;
import com.spark.lms.model.User;
import com.spark.lms.service.MemberService;
import com.spark.lms.service.UserService;

@RestController
@RequestMapping(value = "/rest/member")
public class MemberRestController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private UserService userService;
	
	@GetMapping(value = {"/", "/list"})
	public List<Member> all() {
		return memberService.getAll();
	}
//	@GetMapping(value = {"/", "/list"})
//	public List<User> all() {
//		return userService.getAllUsers();
//	}
	
}
