package br.com.rodrigofernandes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rodrigofernandes.model.Formacao;
import br.com.rodrigofernandes.repository.FormacaoRepository;

public class FormacaoService {
	
	@Autowired
	private FormacaoRepository fRepository;
	
	public List<Formacao> todos(){
		return fRepository.findAll();
	}
	
	public void save(Formacao formacao) {
		fRepository.save(formacao);
	}
	
	public Formacao buscarFormacao(Long id) {
		return fRepository.findById(id).get();
	}
	
	public void excluirFormacao(Long id) {
		fRepository.deleteById(id);
	}

}
