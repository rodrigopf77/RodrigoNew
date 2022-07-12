package br.com.rodrigofernandes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rodrigofernandes.model.Empresa;
import br.com.rodrigofernandes.repository.Empresas;

@Service
@Transactional
public class EmpresaService {
	
	@Autowired
	private Empresas rep;
	
	public List<Empresa> todos(){
		return rep.findAll();
	}
	
	public void save(Empresa empresa) {
		rep.save(empresa);
	}
	
	public Empresa buscarEmpresa(Long id) {
		return rep.findById(id).get();
	}
	
	public void excluirEmpresa(Long id) {
		rep.deleteById(id);
	}
	

}
