package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.model.GameList;
import com.devsuperior.dslist.repository.IGameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private IGameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDto> findAll(){
		List<GameList> listaGame = gameListRepository.findAll();
		return listaGame.stream().map(x -> new GameListDto(x)).toList();
	}
	
//	@Transactional(readOnly = true)
//	public GameDto findById(Long id) {
//		return new GameDto(gameRepository.findById(id).get());
//	}

}
