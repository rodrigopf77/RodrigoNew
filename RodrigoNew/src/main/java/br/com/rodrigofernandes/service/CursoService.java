package br.com.rodrigofernandes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rodrigofernandes.model.Produto;
import br.com.rodrigofernandes.repository.CursoRepository;

@Service
@Transactional
public class CursoService {

	@Autowired
	private CursoRepository cRepository;
	
	public List<Produto> todos(){
		return cRepository.findAll();
	}
	
	public void save(Produto curso) {
		cRepository.save(curso);
	}
	
	public Produto buscarCurso(Long id) {
		return cRepository.findById(id).get();
	}
	
	public void excluirCurso(Long id) {
		cRepository.deleteById(id);
	}
	
}
