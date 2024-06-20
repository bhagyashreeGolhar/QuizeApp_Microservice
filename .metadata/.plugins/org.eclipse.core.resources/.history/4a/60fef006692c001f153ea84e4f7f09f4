package com.SpringBoot.QuizeApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.SpringBoot.QuizeApp.Entity.*;
import com.SpringBoot.QuizeApp.Model.QuestionWrapper;
import com.SpringBoot.QuizeApp.Model.QuizeSubmitResponse;
import com.SpringBoot.QuizeApp.Service.QuizeService;

@RestController
@RequestMapping("/quize")
public class QuizeController {
	
	@Autowired
	QuizeService quizeservice;
	
	@GetMapping("/create")
	public ResponseEntity<String> createQuize(@RequestParam String category,@RequestParam int numQ,@RequestParam String title)
	{
		ResponseEntity<String> res=quizeservice.createQuize(category, numQ, title);
		return new ResponseEntity(res,HttpStatus.OK);
	}
	
	@GetMapping("/getQuize/{title}")
	public ResponseEntity<List<QuestionWrapper>> getQuize(@PathVariable String title)
	{
		ResponseEntity<List<QuestionWrapper>> que=quizeservice.getQuize(title);
		return que;
	}
	
	@PostMapping("/submitQuize/{quizeId}")
	public ResponseEntity<Integer> SubmitQuize(@PathVariable int quizeId, @RequestBody List<QuizeSubmitResponse> quizeans)
	{
		ResponseEntity<Integer> score=quizeservice.calculateScore(quizeId,quizeans);
		return score;
	}

}
