package com.spark.lms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spark.lms.model.Category;
import com.spark.lms.service.CategoryService;

@Controller
@RequestMapping(value = "/Studentcategory")
public class StudentCategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String showCategoriesPage(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return "/Studentcategory/list";
	}
	
	
	
	
	
	
	
	
}
