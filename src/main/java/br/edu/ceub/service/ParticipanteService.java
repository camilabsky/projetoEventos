package br.edu.ceub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ceub.domain.Participante;
import br.edu.ceub.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<Participante> findParticipantByName(String nome) {
        return participanteRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Participante> findParticipantByEmail(String email) {
        return participanteRepository.findByEmailContainingIgnoreCase(email);
    }

    public Participante findParticipantById(Long id) {
        return participanteRepository.findById(id).orElse(null);
    }

    public void deleteParticipantById(Long id) {
        participanteRepository.deleteById(id);
    }
}