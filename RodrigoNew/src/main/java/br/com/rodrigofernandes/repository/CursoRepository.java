package br.com.rodrigofernandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodrigofernandes.model.Produto;

public interface CursoRepository extends JpaRepository<Produto, Long> {

}
