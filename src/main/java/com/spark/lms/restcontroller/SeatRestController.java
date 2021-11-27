package com.spark.lms.restcontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spark.lms.common.Constants;
import com.spark.lms.model.Book;
import com.spark.lms.model.Issue;
import com.spark.lms.model.IssuedBook;
import com.spark.lms.model.Member;
import com.spark.lms.model.SeatAllocation;
import com.spark.lms.model.User;
import com.spark.lms.repository.SeatRepository;
import com.spark.lms.service.BookService;
import com.spark.lms.service.IssueService;
import com.spark.lms.service.IssuedBookService;
import com.spark.lms.service.MemberService;
import com.spark.lms.service.SeatService;
import com.spark.lms.service.UserService;

@RestController
@RequestMapping(value = "/rest/seatissue")
public class SeatRestController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private SeatService seatService;
	@Autowired
	private SeatRepository SeatRepo;
	
	@Autowired
	private IssuedBookService issuedBookService;
	@Autowired
	private UserService userService;
	
	Long TotalSeats=(long)50;
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(@RequestParam Map<String, String> payload) {
		
		String memberIdStr = (String)payload.get("member");
		
		
		Long memberId = null;
		try {
			memberId = Long.parseLong( memberIdStr );
			
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			return "invalid number format";
		}
		
		//if(se==null) {
			
		
		  
		Member member = memberService.get( memberId );
		List<SeatAllocation> s= seatService.getMember(member);
		
		if(s.isEmpty()) {
			System.out.println("Hello");
	    SeatAllocation seat = new SeatAllocation();
	     if(SeatRepo.count()<TotalSeats) {
		 seat.setMember(member);
		 seatService.addNew(seat);
	     }
		}
		
		
		//}
		
		
		
		return "success";
	}
	
//	@RequestMapping(value = "/{id}/return/all", method = RequestMethod.GET)
//	public String returnAll(@PathVariable(name = "id") Long id) {
//		SeatAllocation seat = seatService.get(id);
//		if( seat != null ) {
//			seatService.delete(seat);
//			
//			return "successful";
//		} else {
//			return "unsuccessful";
//		}
//	}
	
	@RequestMapping(value="/{id}/return", method = RequestMethod.POST)
	public String returnSelected(@PathVariable(name = "id") Long id) {
		
	      SeatAllocation seat = seatService.get(id);
	      
		if( seat != null ) {
			seatService.delete(seat);
			
			
			
			return "successful";
		} else {
			return "unsuccessful";
		}
	}
	
}
