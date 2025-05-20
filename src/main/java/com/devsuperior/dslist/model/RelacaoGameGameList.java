package com.devsuperior.dslist.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_relacaoGameGameList")
public class RelacaoGameGameList {
	
	@EmbeddedId
	private RelacaoGameGameListPK relacaoGameGameListPK = new RelacaoGameGameListPK();
	
	private Integer posicao;
	
	public RelacaoGameGameList(Game game, GameList gameList, Integer position) {
		this.relacaoGameGameListPK.setGame(game);
		this.relacaoGameGameListPK.setGameList(gameList);
		this.posicao = position;
	}
	
}
