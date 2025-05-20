package com.devsuperior.dslist.model;

import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDto {

    private Long id;

    private String titulo;

    private Integer ano;

    private String genero;

    private String plataforma;

    private Double score;

    private String imgUrl;

    private String descricaoCurta;

    private String descricaoLonga;
    
    public GameDto(Game game) {
    	BeanUtils.copyProperties(game, this);
    }
	
}
