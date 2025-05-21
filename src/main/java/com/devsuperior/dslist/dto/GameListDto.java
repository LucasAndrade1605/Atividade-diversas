package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.model.GameList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameListDto {

	private Long id;
	
	private String nome;
	
	public GameListDto(GameList gameList) {
		this.id = gameList.getId();
		this.nome = gameList.getNome();
	}
	
}
