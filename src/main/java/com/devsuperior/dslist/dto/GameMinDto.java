package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.model.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameMinDto {
	
    private Long id;

    private String titulo;

    private Integer ano;

    private String imgUrl;

    private String descricaoCurta;
    
    public GameMinDto(Game game) {
    	this.id = game.getId();
    	this.titulo = game.getTitulo();
    	this.ano = game.getAno();
    	this.imgUrl = game.getImgUrl();
    	this.descricaoCurta = game.getDescricaoCurta();
    }
    
    public GameMinDto(GameMinProjection game) {
    	this.id = game.getId();
    	this.titulo = game.getTitulo();
    	this.ano = game.getAno();
    	this.imgUrl = game.getImgUrl();
    	this.descricaoCurta = game.getDescricaoCurta();
    }

}
