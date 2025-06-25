package br.edu.ceub.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ceub.domain.Evento;
import br.edu.ceub.service.EventoService;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/nome")
    public ResponseEntity<List<Evento>> getEventByName(@RequestParam String nome) {
        List<Evento> eventos = eventoService.findEventByName(nome);
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/data")
    public ResponseEntity<List<Evento>> getEventByDate(@RequestParam String data) {
        List<Evento> eventos = eventoService.findEventByDate(LocalDate.parse(data));
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventById(@PathVariable Long id) {
        Evento evento = eventoService.findEventById(id);
        return evento != null ? ResponseEntity.ok(evento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEventById(@PathVariable Long id) {
        try {
            eventoService.deleteEventById(id);
            return ResponseEntity.ok("Evento deletado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Evento não encontrado!");
        }
    }
}