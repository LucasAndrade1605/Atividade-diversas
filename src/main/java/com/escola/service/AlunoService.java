package com.escola.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.escola.model.Aluno;
import com.escola.repository.AlunoRepository;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }
    public Aluno buscar(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }
    public void remover(Long id) {
        alunoRepository.deleteById(id);
    }
}