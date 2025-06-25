package br.edu.ceub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ceub.domain.Local;
import br.edu.ceub.service.LocalService;

@RestController
@RequestMapping("/api/locais")
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping
    public ResponseEntity<List<Local>> getAllLocais() {
        List<Local> locais = localService.findAll();
        return ResponseEntity.ok(locais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Local> getLocalById(@PathVariable Long id) {
        Local local = localService.findLocalById(id);
        return local != null ? ResponseEntity.ok(local) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocalById(@PathVariable Long id) {
        try {
            localService.deleteLocalById(id);
            return ResponseEntity.ok("Local deletado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Local não encontrado!");
        }
    }
}