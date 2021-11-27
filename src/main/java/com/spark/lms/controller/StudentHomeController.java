package com.spark.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spark.lms.service.HomeService;

@Controller
public class StudentHomeController {

	@Autowired
	HomeService homeService;
	
	@RequestMapping(value = {"/", "/StudentHome"}, method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("topTiles", homeService.getTopTilesMap());
		return "StudentHome";
	}	
	
}
