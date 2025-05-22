package com.devsuperior.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.model.GameList;

public interface IGameListRepository extends JpaRepository<GameList, Long>{
	
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE tb_relacao_game_game_list SET posicao = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);

}
