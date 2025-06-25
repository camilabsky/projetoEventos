package br.edu.ceub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ceub.domain.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
}