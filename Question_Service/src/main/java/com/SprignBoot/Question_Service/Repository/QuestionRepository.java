package com.SprignBoot.Question_Service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SprignBoot.Question_Service.Entity.Question;

import org.springframework.data.repository.query.Param;



@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	public List<Question> findBycategory(String category);

	
	@Query(value = "SELECT q.id FROM question q WHERE q.category = ?1 ORDER BY RAND() LIMIT ?2", nativeQuery = true)
	public List<Integer> findQuestionBycategory(String category, int numQ);


	

}
