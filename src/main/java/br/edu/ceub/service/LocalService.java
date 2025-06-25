package br.edu.ceub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ceub.domain.Local;
import br.edu.ceub.repository.LocalRepository;

@Service
public class LocalService {
    @Autowired
    private LocalRepository localRepository;

    public List<Local> findAll() {
        return localRepository.findAll();
    }

    public Local findLocalById(Long id) {
        return localRepository.findById(id).orElse(null);
    }

    public void deleteLocalById(Long id) {
        localRepository.deleteById(id);
    }
}