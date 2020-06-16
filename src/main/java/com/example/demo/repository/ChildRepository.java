package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {
	
	public Child findByidchild(Integer id);
	 @Query(value="select imageUrl,firstname,lastname,old,adress from child", nativeQuery=true)
  public List<Child> getInfo();
	
}
