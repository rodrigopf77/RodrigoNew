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
public class ExperienciaProfissional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_experiencia_profissional")
	private long id;
	private String cargo;
	private String funcao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="experiencia_profissional_empresa_id", referencedColumnName = "id")
	private Empresa instituicao;

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

	public Empresa getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Empresa instituicao) {
		this.instituicao = instituicao;
	}
	

}
