package com.SpringBoot.QuizeApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.QuizeApp.Entity.Quize;

@Repository
public interface QuizeRepository extends JpaRepository<Quize, Integer> {

	Quize findByTitle(String title);

}
