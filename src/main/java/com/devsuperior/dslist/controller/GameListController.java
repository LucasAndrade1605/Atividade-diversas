package com.devsuperior.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.dto.ReplacementDto;
import com.devsuperior.dslist.model.GameDto;
import com.devsuperior.dslist.service.GameListService;
import com.devsuperior.dslist.service.GameService;


@Controller
@RequestMapping("/list")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public ResponseEntity<List<GameListDto>> findAll(){
		return ResponseEntity.ok(gameListService.findAll());
	}
	
	@GetMapping("{listId}/game")
	public ResponseEntity<List<GameMinDto>> findByList(@PathVariable Long listId){
		return ResponseEntity.ok(gameService.findByList(listId));
	}
	
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<GameListDto> findById(@PathVariable Long id){
//		return ResponseEntity.ok(gameListService.findById(id));
//	}
	
	@PostMapping("/{listId}/move")
	public ResponseEntity<?> move(@PathVariable Long listId, @RequestBody ReplacementDto body){
		gameListService.move(listId, body.getIndexAtual(), body.getIndexDestino());
		return ResponseEntity.ok("Atualizacao completa");
	}
}
