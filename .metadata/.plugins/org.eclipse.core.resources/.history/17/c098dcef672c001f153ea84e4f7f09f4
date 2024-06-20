package com.SpringBoot.QuizeApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringBoot.QuizeApp.Entity.Question;
import com.SpringBoot.QuizeApp.Entity.Quize;
import com.SpringBoot.QuizeApp.Model.QuestionWrapper;
import com.SpringBoot.QuizeApp.Model.QuizeSubmitResponse;
import com.SpringBoot.QuizeApp.Repository.QuestionRepository;
import com.SpringBoot.QuizeApp.Repository.QuizeRepository;

@Service
public class QuizeService {
	
	@Autowired
	QuizeRepository quizeRepository;
	@Autowired
	QuestionRepository questionRepository;
	public ResponseEntity<String> createQuize(String category,int numQ,String tilte)
	{
		List<Question> questions=questionRepository.findQuestionBycategory(category,numQ);
		for(Question q:questions)
		{
			System.out.println("Que is: "+ q.getId());
		}
		Quize quize=new Quize();
		quize.setTitle(tilte);
		quize.setQuestions(questions);
		quizeRepository.save(quize);
		return new ResponseEntity("Quize created",HttpStatus.OK);
	}
	
	public ResponseEntity<List<QuestionWrapper>> getQuize(String title) {
		Quize quizebytitle=quizeRepository.findByTitle(title);
		Integer id=quizebytitle.getId();
		Optional<Quize> quize=quizeRepository.findById(id);
		List<Question> que=quize.get().getQuestions();
		List<QuestionWrapper> quizeQue=new ArrayList();
		for(Question q: que)
		{
			QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuetiontitle(), q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			quizeQue.add(qw);
		}
		
		return new ResponseEntity(quizeQue,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateScore(int id, List<QuizeSubmitResponse> quizeans) {
		Integer count=0;
		for(QuizeSubmitResponse q:quizeans)
		{
			String selectAns=q.getSelectedans();
			Optional<Question> Que=questionRepository.findById(q.getId());
			String correctAns=Que.get().getCorrectans();
			if(selectAns.equals(correctAns))
			{
				count++;
			}
			
		}
		return new ResponseEntity(count,HttpStatus.OK);
	}

}
