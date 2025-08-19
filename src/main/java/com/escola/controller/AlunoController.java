package com.escola.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.model.Aluno;
import com.escola.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;
    public AlunoController(AlunoService alunoService) { this.alunoService = alunoService; }

    @GetMapping
    public List<Aluno> listar() {
        return alunoService.listar();
    }

    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno);
    }

    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Long id) {
        return alunoService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        alunoService.remover(id);
    }
}