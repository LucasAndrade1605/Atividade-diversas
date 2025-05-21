package com.devsuperior.dslist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.model.Game;
import com.devsuperior.dslist.model.GameDto;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repository.IGameRepository;

@Service
public class GameService {
	
	@Autowired
	private IGameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findAll(){
		List<GameMinDto> listaGameDto = new ArrayList<GameMinDto>();
		List<Game> listaGame = gameRepository.findAll();
		
		for (Game game : listaGame) {
			GameMinDto gameDto = new GameMinDto(game);
			listaGameDto.add(gameDto);
		}
		
		return listaGameDto;
	}
	
	@Transactional(readOnly = true)
	public GameDto findById(Long id) {
		return new GameDto(gameRepository.findById(id).get());
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDto> findByList(Long listId){
		List<GameMinProjection> listaGamePJ = gameRepository.searchByList(listId);
		
		return listaGamePJ.stream().map(x -> new GameMinDto(x)).toList();
	}

}
