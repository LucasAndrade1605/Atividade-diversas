package com.devsuperior.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.model.GameDto;
import com.devsuperior.dslist.service.GameService;


@Controller
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public ResponseEntity<List<GameMinDto>> findAll(){
		return ResponseEntity.ok(gameService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GameDto> findById(@PathVariable Long id){
		return ResponseEntity.ok(gameService.findById(id));
	}
}
