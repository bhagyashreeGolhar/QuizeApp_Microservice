package com.SpringBoot.QuizeApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.SpringBoot.QuizeApp.Entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	public List<Question> findBycategory(String category);

	/*
	 * @Query(
	 * value="SELECT * FROM question q where q.category = : category ORDER BY RAND() LIMIT :numQ"
	 * ,nativeQuery = true) public List<Question>
	 * findQuestionBycategory(@Param("category") String category, @Param("numQ") int
	 * numQ);
	 */
	
	@Query(value = "SELECT * FROM question q WHERE q.category = ?1 ORDER BY RAND() LIMIT ?2", nativeQuery = true)
	public List<Question> findQuestionBycategory(String category, int numQ);

	

}
