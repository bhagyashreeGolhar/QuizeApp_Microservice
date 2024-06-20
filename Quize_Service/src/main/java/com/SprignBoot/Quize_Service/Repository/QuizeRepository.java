package com.SprignBoot.Quize_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SprignBoot.Quize_Service.Entity.Quize;

@Repository
public interface QuizeRepository extends JpaRepository<Quize, Integer> {

	Quize findByTitle(String title);

}
