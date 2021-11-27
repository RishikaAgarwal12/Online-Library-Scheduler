package com.spark.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spark.lms.model.Issue;
import com.spark.lms.model.Member;
import com.spark.lms.model.SeatAllocation;

@Repository
public interface SeatRepository extends JpaRepository<SeatAllocation, Long> {
	public List<SeatAllocation> findAllByMember(Member member);
	
}
