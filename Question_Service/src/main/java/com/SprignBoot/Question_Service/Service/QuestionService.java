package com.SprignBoot.Question_Service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SprignBoot.Question_Service.Entity.Question;
import com.SprignBoot.Question_Service.Model.QuestionWrapper;
import com.SprignBoot.Question_Service.Model.QuizeSubmitResponse;
import com.SprignBoot.Question_Service.Repository.QuestionRepository;



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

	public ResponseEntity<List<Integer>> generateQuestionsForQuize(String category, int numQ) {
		
		List<Integer> questionsId=questionRepository.findQuestionBycategory(category,numQ);
		return new ResponseEntity(questionsId,HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionById(List<Integer> questionIds) {
	
		List<Question> questions=new ArrayList<Question>();
		List<QuestionWrapper> questionwrapper=new ArrayList<QuestionWrapper>();
		for(int id:questionIds)
		{
		    Question que=questionRepository.findById(id).get();
			questions.add(que);
		}
		for(Question q:questions)
		{
			QuestionWrapper wrapper=new QuestionWrapper(q.getId(), q.getQuetiontitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionwrapper.add(wrapper);
		}
		return new ResponseEntity(questionwrapper,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<QuizeSubmitResponse> responses) {
		int count=0;
		for(QuizeSubmitResponse res: responses)
		{
			Question que=questionRepository.findById(res.getId()).get();
			if(que.getCorrectans().equals(res.getSelectedans()))
			{
				count++;
			}
		}
		return new ResponseEntity<>(count,HttpStatus.OK);
	}
}
