package br.edu.ceub.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ceub.domain.Evento;
import br.edu.ceub.repository.EventoRepository;

@Service
public class EventoService {
    
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> findEventByName(String nome) {
        return eventoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Evento> findEventByDate(LocalDate data) {
        return eventoRepository.findByData(data);
    }

    public Evento findEventById(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    public void deleteEventById(Long id) {
        eventoRepository.deleteById(id);
    }
}