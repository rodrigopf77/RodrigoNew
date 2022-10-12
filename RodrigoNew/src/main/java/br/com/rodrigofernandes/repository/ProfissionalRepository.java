package br.com.rodrigofernandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodrigofernandes.model.ExperienciaProfissional;

public interface ProfissionalRepository extends JpaRepository<ExperienciaProfissional, Long> {

}
