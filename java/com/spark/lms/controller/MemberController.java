package com.spark.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spark.lms.common.Constants;
import com.spark.lms.model.Member;
import com.spark.lms.model.User;
import com.spark.lms.service.MemberService;
import com.spark.lms.service.UserService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	Long nid=(long)3;

	@Autowired
	private MemberService memberService;
	@Autowired
	private UserService userService;
	
	@ModelAttribute(name = "memberTypes")
	public List<String> memberTypes() {
		return Constants.MEMBER_TYPES;
	}
     
	
	@RequestMapping(value = {"/", "/list"},  method = RequestMethod.GET)
	public String showMembersPage(Model model) {
		model.addAttribute("members", memberService.getAll());
		return "/member/list";
	}
//	@RequestMapping(value = {"/", "/list"},  method = RequestMethod.GET)
//	public String showMembersPage(Model model) {
//		model.addAttribute("members", userService.getAllUsers());
//		return "/member/list";
//	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addMemeberPage(Model model) {
		model.addAttribute("member", new Member());
		return "/member/form";
	}
//	@RequestMapping(value = "/add", method = RequestMethod.GET)
//	public String addMemeberPage(Model model) {
//		model.addAttribute("member", new User());
//		return "/member/form";
//	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editMemeberPage(@PathVariable(name = "id") Long id, Model model) {
		
		Member member = memberService.get( id );
		if( member != null ) {
			model.addAttribute("member", member);
			return "/member/form";
		} else {
			return "redirect:/member/add";
		}
	}
//	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//	public String editMemeberPage(@PathVariable(name = "id") Long id, Model model) {
//		
//		User member = userService.getById( id );
//		if( member != null ) {
//			model.addAttribute("member", member);
//			return "/member/form";
//		} else {
//			return "redirect:/member/add";
//		}
//	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveMember(@Valid Member member, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		System.out.println("Hi");
		if( bindingResult.hasErrors() ) {
			return "/member/form";
		}
		
		if( member.getId() == null ) {
			member.setId(nid);
			nid++;
			User user =new User();
			user.setId(member.getId());
			user.setDisplayName(member.getFirstName()+" "+member.getLastName());
			user.setUsername(member.getFirstName());
			user.setPassword(member.getFirstName()+String.valueOf(member.getId()));
			user.setRole(member.getType());
			userService.addNew(user);
			
			memberService.addNew(member);
			redirectAttributes.addFlashAttribute("successMsg", "'" + member.getFirstName()+" "+member.getLastName() + " "+"with ID"+" "+ member.getId()+ "' is added as a new member.");
			return "redirect:/member/add";
		} else {
			Member updatedMember = memberService.save( member );
			redirectAttributes.addFlashAttribute("successMsg", "Changes for '" + member.getFirstName()+" "+member.getLastName() + "' are saved successfully. ");
			return "redirect:/member/edit/" + updatedMember.getId();
		}
	}
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String saveMember(@Valid User member, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
//		System.out.println("Hi");
//		if( bindingResult.hasErrors() ) {
//			return "/member/form";
//		}
//		
//		if( member.getId() == null ) {
//			
//			userService.addNew(member);
//			redirectAttributes.addFlashAttribute("successMsg", "'" + member.getDisplayName() + "' is added as a new member.");
//			return "redirect:/member/add";
//		} else {
//			User updatedMember = userService.save( member );
//			redirectAttributes.addFlashAttribute("successMsg", "Changes for '" + member.getDisplayName()+ "' are saved successfully. ");
//			return "redirect:/member/edit/" + updatedMember.getId();
//		}
//	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String removeMember(@PathVariable(name = "id") Long id, Model model) {
		Member member = memberService.get( id );
		if( member != null ) {
			if( memberService.hasUsage(member) ) {
				model.addAttribute("memberInUse", true);
				return showMembersPage(model);
			} else {
				memberService.delete(id);
			}
		}
		return "redirect:/member/list";
	}
//	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
//	public String removeMember(@PathVariable(name = "id") Long id, Model model) {
//		User member = userService.getById( id );
//		if( member != null ) {
//			if( memberService.hasUsage(member) ) {
//				model.addAttribute("memberInUse", true);
//				return showMembersPage(model);
//			} else {
//				userService.delete(id);
//			}
//		}
//		return "redirect:/member/list";
//	}
	
	
	
	
}
