package com.devsuperior.dslist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.model.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

public interface IGameRepository extends JpaRepository<Game, Long>{
	
	@Query(value = """
		    SELECT tb_game.id, 
		           tb_game.titulo, 
		           tb_game.ano AS ano, 
		           tb_game.img_url AS imgUrl,
		           tb_game.descricao_curta AS descricao_curta, 
		           tb_relacao_game_game_list.posicao 
		    FROM tb_game 
		    INNER JOIN tb_relacao_game_game_list 
		    ON tb_game.id = tb_relacao_game_game_list.game_id 
		    WHERE tb_relacao_game_game_list.list_id = ?1 
		    ORDER BY tb_relacao_game_game_list.posicao
		""", nativeQuery = true)
	List<GameMinProjection> searchByList(Long listId);
	
}
