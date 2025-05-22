package com.devsuperior.dslist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.model.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repository.IGameListRepository;
import com.devsuperior.dslist.repository.IGameRepository;

@Service
public class GameListService {
	
	@Autowired
	private IGameListRepository gameListRepository;
	
	@Autowired
	private IGameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDto> findAll(){
		List<GameList> listaGame = gameListRepository.findAll();
		return listaGame.stream().map(x -> new GameListDto(x)).toList();
	}
	
//	@Transactional(readOnly = true)
//	public GameDto findById(Long id) {
//		return new GameDto(gameRepository.findById(id).get());
//	}
	
	@Transactional
	public void move(Long listId, Integer indexAtual, Integer indexDestino) {
		
		List<GameMinProjection> listaGamePJ = gameRepository.searchByList(listId);
		
		GameMinProjection gameTemp = listaGamePJ.get(indexAtual);
		
		listaGamePJ.remove(indexAtual);
		listaGamePJ.add(indexDestino, gameTemp);
		
		int min = indexAtual < indexDestino ? indexAtual : indexDestino;
		int max = indexAtual > indexDestino ? indexAtual : indexDestino;
		
		for(int cont=min; cont <= max; cont++) {
			gameListRepository.updateBelongingPosition(listId, listaGamePJ.get(cont).getId(), cont);
		}
		
	}

}
