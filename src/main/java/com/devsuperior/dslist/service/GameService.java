package com.devsuperior.dslist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.model.Game;
import com.devsuperior.dslist.repository.IGameRepository;

@Service
public class GameService {
	
	@Autowired
	private IGameRepository gameRepository;
	
	public List<GameMinDto> findAll(){
		List<GameMinDto> listaGameDto = new ArrayList<GameMinDto>();
		List<Game> listaGame = gameRepository.findAll();
		
		for (Game game : listaGame) {
			GameMinDto gameDto = new GameMinDto(game);
			listaGameDto.add(gameDto);
		}
		
		return listaGameDto;
	}

}
