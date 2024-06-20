package com.SpringBoot.QuizeApp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringBoot.QuizeApp.Entity.Question;
import com.SpringBoot.QuizeApp.Repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		try
		{
			List<Question> questions =questionRepository.findAll() ;
			return new ResponseEntity(questions, HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in getAllquestion method: "+e.getMessage());
		}
		return new ResponseEntity(new ArrayList(),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try
		{
			List<Question> javaQue=questionRepository.findBycategory(category);
			return new ResponseEntity(javaQue,HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in getQuestionByCategory"+ e.getMessage());
		}
		return new ResponseEntity(new ArrayList(),HttpStatus.BAD_REQUEST);
	}
		

	public ResponseEntity<String> addQuestion (Question question) {
		try
		{
		 questionRepository.save(question);
		 return new ResponseEntity("Success", HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in addQuestion "+e.getMessage());
		}
		return new ResponseEntity("Fail", HttpStatus.OK);
	}
}
