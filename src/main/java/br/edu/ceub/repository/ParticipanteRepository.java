package br.edu.ceub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ceub.domain.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    List<Participante> findByNomeContainingIgnoreCase(String nome);

    List<Participante> findByEmailContainingIgnoreCase(String email);
}