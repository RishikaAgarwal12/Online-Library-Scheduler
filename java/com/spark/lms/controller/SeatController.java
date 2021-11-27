package com.spark.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spark.lms.common.Constants;
import com.spark.lms.model.Category;
import com.spark.lms.service.CategoryService;
import com.spark.lms.service.IssueService;
import com.spark.lms.service.SeatService;

@Controller
@RequestMapping(value = "/seatissue")
public class SeatController {

	@Autowired
	private SeatService seatService;
	
	
	
	@ModelAttribute(name = "memberTypes")
	public List<String> memberTypes() {
		return Constants.MEMBER_TYPES;
	}
	
	
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String listIssuePage(Model model) {
		model.addAttribute("issues", seatService.getAll());
		return "/Seat/list";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newIssuePage(Model model) { 
		return "/Seat/form";
	}
	
}
