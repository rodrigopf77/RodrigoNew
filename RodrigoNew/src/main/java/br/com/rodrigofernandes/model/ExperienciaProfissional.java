package br.com.rodrigofernandes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import groovy.transform.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ExperienciaProfissional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id_experiencia")
	private long id;
	
	@Column(name= "cargo")
	private String cargo;
	
	@Column(name= "funcao")
	private String funcao;
	
	//mappedBy reference an unknown target entity property: br.com.rodrigofernandes.model.Produto.empresa 
	//in br.com.rodrigofernandes.model.Empresa.experiencias
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="experiencia_empresa_id", referencedColumnName = "id")
	private Empresa empresa;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
