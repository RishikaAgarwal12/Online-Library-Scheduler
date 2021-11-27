package com.spark.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spark.lms.model.Book;
import com.spark.lms.model.Category;
import com.spark.lms.model.Member;
import com.spark.lms.model.SeatAllocation;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	public List<Category> findAllByOrderByNameAsc();
	public List<Category> findAllByName(String name);
}
