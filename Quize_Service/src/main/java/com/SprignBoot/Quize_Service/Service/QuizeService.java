package com.SprignBoot.Quize_Service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SprignBoot.Quize_Service.Entity.Quize;
import com.SprignBoot.Quize_Service.Model.QuestionWrapper;
import com.SprignBoot.Quize_Service.Model.QuizeSubmitResponse;
import com.SprignBoot.Quize_Service.QuizefeginInterface.QuizeFignInterface;
import com.SprignBoot.Quize_Service.Repository.QuizeRepository;
@Service
public class QuizeService {
	
	@Autowired
	QuizeRepository quizeRepository;
	
	@Autowired
	QuizeFignInterface quizefignInterface;
	
	public ResponseEntity<String> createQuize(String category,int numQ,String tilte)
	{
		List<Integer> questionsIds=quizefignInterface.generateQuestionsForQuize(category, numQ).getBody();
		Quize quize=new Quize();
		quize.setTitle(tilte);
		quize.setQuestionIds(questionsIds);
		quizeRepository.save(quize);
		
		return new ResponseEntity("Quize created",HttpStatus.OK);
	}
	
	public ResponseEntity<List<QuestionWrapper>> getQuize(int id) {
		 List<QuestionWrapper> quizeQue=null;
		 Optional<Quize> quize=quizeRepository.findById(id);
		 List<Integer> quesids=quize.get().getQuestionIds();
		 List<QuestionWrapper> questions=quizefignInterface.getQuestionByQuizeId(quesids).getBody();
		return new ResponseEntity(questions,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateScore(int id, List<QuizeSubmitResponse> quizeans) {
		Integer count=0;
		count= quizefignInterface.getScore(quizeans).getBody();
		return new ResponseEntity(count,HttpStatus.OK);
	}

}
