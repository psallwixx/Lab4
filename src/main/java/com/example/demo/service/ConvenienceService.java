package com.example.demo.service;

import com.example.demo.model.Convenience;
import com.example.demo.repository.ConvenienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvenienceService {
    private final ConvenienceRepository convenienceRepository;

    public ConvenienceService(ConvenienceRepository convenienceRepository) {
        this.convenienceRepository = convenienceRepository;
    }

    public List<Convenience> getAllConveniences() {
        return convenienceRepository.findAll();
    }

    public Convenience getConvenienceById(Long id) {
        return convenienceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Convenience not found"));
    }

    public Convenience createConvenience(Convenience convenience) {
        return convenienceRepository.save(convenience);
    }

    public Convenience updateConvenience(Long id, Convenience updatedConvenience) {
        Convenience convenience = getConvenienceById(id);
        convenience.setName(updatedConvenience.getName());
        return convenienceRepository.save(convenience);
    }

    public void deleteConvenience(Long id) {
        convenienceRepository.deleteById(id);
    }
}
