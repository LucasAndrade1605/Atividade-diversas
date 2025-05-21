package com.devsuperior.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.model.GameDto;
import com.devsuperior.dslist.service.GameListService;


@Controller
@RequestMapping("/list")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@GetMapping
	public ResponseEntity<List<GameListDto>> findAll(){
		return ResponseEntity.ok(gameListService.findAll());
	}
	
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<GameListDto> findById(@PathVariable Long id){
//		return ResponseEntity.ok(gameListService.findById(id));
//	}
}
