package com.SprignBoot.Quize_Service.QuizefeginInterface;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.SprignBoot.Quize_Service.Model.QuestionWrapper;
import com.SprignBoot.Quize_Service.Model.QuizeSubmitResponse;


@FeignClient("QUESTION-SERVICE")
public interface QuizeFignInterface {
	
	@GetMapping("questions/generateQuestionsForQuize")
	public ResponseEntity<List<Integer>> generateQuestionsForQuize(@RequestParam("category") String category, @RequestParam int numQ);

	@PostMapping("questions/getQuestionById")
	public ResponseEntity<List<QuestionWrapper>> getQuestionByQuizeId(@RequestBody List<Integer> questionIds);
	
	@PostMapping("questions/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<QuizeSubmitResponse> responses);
	

}
