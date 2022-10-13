package br.com.rodrigofernandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodrigofernandes.model.Formacao;

public interface FormacaoRepository extends JpaRepository<Formacao, Long> {

}
