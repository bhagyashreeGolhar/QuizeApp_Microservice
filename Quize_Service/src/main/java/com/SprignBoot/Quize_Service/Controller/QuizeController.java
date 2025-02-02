package com.SprignBoot.Quize_Service.Controller;

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

import com.SprignBoot.Quize_Service.DTO.QuizeDTO;
import com.SprignBoot.Quize_Service.Model.QuestionWrapper;
import com.SprignBoot.Quize_Service.Model.QuizeSubmitResponse;
import com.SprignBoot.Quize_Service.Service.QuizeService;


@RestController
@RequestMapping("/quize")
public class QuizeController {
	
	@Autowired
	QuizeService quizeservice;
	
	@GetMapping("/create")
	public ResponseEntity<String> createQuize(@RequestBody QuizeDTO quizedto)
	{
		ResponseEntity<String> res=quizeservice.createQuize( quizedto.getCategoryName(),quizedto.getNumQ(),quizedto.getTitle());
		return new ResponseEntity(res,HttpStatus.OK);
	}
	
	@GetMapping("/getQuize/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuize(@PathVariable int id)
	{
		ResponseEntity<List<QuestionWrapper>> que=quizeservice.getQuize(id);
		return que;
	}
	
	@PostMapping("/submitQuize/{quizeId}")
	public ResponseEntity<Integer> SubmitQuize(@PathVariable int quizeId, @RequestBody List<QuizeSubmitResponse> quizeans)
	{
		ResponseEntity<Integer> score=quizeservice.calculateScore(quizeId,quizeans);
		return score;
	}

}
