package com.SpringBoot.QuizeApp.Entity;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Quize")
public class Quize {

	@javax.persistence.Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer Id;
	private String title;
	
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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@ManyToMany
	private List<Question> questions;
}
