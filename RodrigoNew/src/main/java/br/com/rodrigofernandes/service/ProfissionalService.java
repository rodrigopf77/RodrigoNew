package br.com.rodrigofernandes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rodrigofernandes.model.ExperienciaProfissional;
import br.com.rodrigofernandes.repository.ProfissionalRepository;

@Service
@Transactional
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository pRepository;
	
	public List<ExperienciaProfissional> todos(){
		return pRepository.findAll();
	}
	
	public void save(ExperienciaProfissional experiencia) {
		pRepository.save(experiencia);
	}
	
	public ExperienciaProfissional buscarExperiencia(Long id) {
		return pRepository.findById(id).get();
	}
	
	public void excluirExperiencia(Long id) {
		pRepository.deleteById(id);
	}
	
}
