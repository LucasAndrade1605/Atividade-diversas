package com.devsuperior.dslist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_game")
public class Game {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", updatable = false)
	    private Long id;

	    @Column(nullable = false, length = 100)
	    private String titulo;

	    @Column(nullable = false)
	    private Integer ano;

	    @Column(length = 50)
	    private String genero;

	    @Column(length = 50)
	    private String plataforma;

	    private Double score;

	    @Column(name = "img_url", length = 255)
	    private String imgUrl;

	    @Column(name = "descricao_curta", length = 500)
	    private String descricaoCurta;

	    @Column(name = "descricao_longa", columnDefinition = "TEXT")
	    private String descricaoLonga;
	
}
