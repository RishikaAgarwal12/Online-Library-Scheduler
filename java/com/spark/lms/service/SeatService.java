package com.spark.lms.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spark.lms.common.Constants;
import com.spark.lms.model.Member;
import com.spark.lms.model.SeatAllocation;
import com.spark.lms.repository.SeatRepository;

@Service
public class SeatService {

	@Autowired
	private SeatRepository seatRepository;
	
	public List<SeatAllocation> getAll() {
		return seatRepository.findAll();
	}
	
	public SeatAllocation get(Long id) {
		 return seatRepository.findById(id).get();
	}
	
	public List<SeatAllocation> getMember(Member member) {
		return( seatRepository.findAllByMember(member));
	}
	
	
	public SeatAllocation addNew(SeatAllocation seat) {
		seat.setIssueDate( new Date() );
		return seatRepository.save(seat);
	}
	public void delete(SeatAllocation seat) {
		seatRepository.delete(seat);
		return;
		
	}
	
	public SeatAllocation save(SeatAllocation seat) {
		return seatRepository.save(seat);
	}
	public Long getTotalIssuedSeats() {
		return seatRepository.count();
	}
}
