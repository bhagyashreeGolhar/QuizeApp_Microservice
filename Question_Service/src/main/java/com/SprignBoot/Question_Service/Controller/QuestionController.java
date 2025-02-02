package com.SprignBoot.Question_Service.Controller;

import java.util.List;

/*import javax.annotation.PostConstruct;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SprignBoot.Question_Service.Entity.Question;
import com.SprignBoot.Question_Service.Model.QuestionWrapper;
import com.SprignBoot.Question_Service.Model.QuizeSubmitResponse;
import com.SprignBoot.Question_Service.Service.QuestionService;



@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		//List<Question> questions=quizeService.getAllQuestions();
		//return questions;
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/Category/{category}")
	public ResponseEntity<List<Question>> getJavaQuestion(@PathVariable(name="category") String category )
	{
		//List<Question> javaQue=quizeService.getQuestionByCategory(category);
		//return javaQue;
		return questionService.getQuestionByCategory(category);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question)
	{
		//String s=quizeService.addQuestion(question);
		return questionService.addQuestion(question);
	}
	
	@GetMapping("/generateQuestionsForQuize")
	public ResponseEntity<List<Integer>> generateQuestionsForQuize(@RequestParam("category") String category, @RequestParam int numQ)
	{
		ResponseEntity<List<Integer>> res=questionService.generateQuestionsForQuize(category,numQ);
		return res;
	}

	@PostMapping("/getQuestionById")
	public ResponseEntity<List<QuestionWrapper>> getQuestionByQuizeId(@RequestBody List<Integer> questionIds)
	{
		ResponseEntity<List<QuestionWrapper>> res=questionService.getQuestionById(questionIds);
		return res;
	}
	
	@PostMapping("/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<QuizeSubmitResponse> responses)
	{
		ResponseEntity<Integer> score=questionService.getScore(responses);
		
		return score;
	}
	
	
}
