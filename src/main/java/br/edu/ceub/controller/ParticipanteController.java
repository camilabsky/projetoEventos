package br.edu.ceub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ceub.domain.Participante;
import br.edu.ceub.service.ParticipanteService;

@RestController
@RequestMapping("/api/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping("/nome")
    public ResponseEntity<List<Participante>> getParticipantByName(@RequestParam String nome) {
        List<Participante> participantes = participanteService.findParticipantByName(nome);
        return ResponseEntity.ok(participantes);
    }

    @GetMapping("/email")
    public ResponseEntity<List<Participante>> getParticipantByEmail(@RequestParam String email) {
        List<Participante> participantes = participanteService.findParticipantByEmail(email);
        return ResponseEntity.ok(participantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participante> getParticipantById(@PathVariable Long id) {
        Participante participante = participanteService.findParticipantById(id);
        return participante != null ? ResponseEntity.ok(participante) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParticipantById(@PathVariable Long id) {
        try {
            participanteService.deleteParticipantById(id);
            return ResponseEntity.ok("Participante deletado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Participante não encontrado!");
        }
    }
}