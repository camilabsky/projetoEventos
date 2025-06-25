package br.edu.ceub;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ceub.domain.Local;
import br.edu.ceub.domain.Participante;
import br.edu.ceub.domain.Evento;
import br.edu.ceub.repository.EventoRepository;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private EventoRepository eventoRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Cria um local
        Local local = new Local();
        local.setDescricao("Auditório Central");
        local.setRua("SHCGN 707");

        // Cria participantes
        Participante participante1 = new Participante();
        participante1.setNome("Alice");
        participante1.setEmail("Alice@email.com");

        Participante participante2 = new Participante();
        participante2.setNome("Bob");
        participante2.setEmail("Bob@email.com");

        // Cria e salva um evento
        Evento evento = new Evento();
        evento.setNome("Hackathon de Spring Boot");
        evento.setData(LocalDate.now());
        evento.setLocal(local); // Cascade salva o local automaticamente
        evento.setParticipantes(List.of(participante1, participante2)); // Cascade seta participantes automaticamente
        eventoRepository.save(evento);

        System.out.println("Application is running...");
    }
}