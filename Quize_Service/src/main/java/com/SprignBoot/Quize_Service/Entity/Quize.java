package com.SprignBoot.Quize_Service.Entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;*/

@Entity
@Table(name = "Quize")
public class Quize {

	@jakarta.persistence.Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer Id;
	private String title;
	
	@ElementCollection
	List<Integer> questionIds;
	
	public List<Integer> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * public List<Question> getQuestions() { return questions; }
	 * 
	 * public void setQuestions(List<Question> questions) { this.questions =
	 * questions; }
	 * 
	 * @ManyToMany private List<Question> questions;
	 */
}
