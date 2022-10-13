package br.com.rodrigofernandes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id_curso")
	private long id;
	
	@Column(name= "nome_curso")
	private String nome;
	
	@Column(name="nivel_curso")
	private String nivel;
	
	//mappedBy reference an unknown target entity property: br.com.rodrigofernandes.model.Produto.empresa 
		//in br.com.rodrigofernandes.model.Empresa.experiencias
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="curso_empresa_id", referencedColumnName = "id")
	private Empresa instituicao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Empresa getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Empresa instituicao) {
		this.instituicao = instituicao;
	}
}
