package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Child;
import com.example.demo.entity.Donate;
import com.example.demo.entity.User;

@Repository
public interface DonateRepository extends JpaRepository<Donate, Integer>{
	//Donate findByIdchild(int idchild);
	public Donate findByiddonate(Integer id);
}
