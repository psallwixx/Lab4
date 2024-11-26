package com.example.demo.controller;

import com.example.demo.model.Convenience;
import com.example.demo.service.ConvenienceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conveniences")
public class ConvenienceController {
    private final ConvenienceService convenienceService;

    public ConvenienceController(ConvenienceService convenienceService) {
        this.convenienceService = convenienceService;
    }

    @GetMapping
    public List<Convenience> getAllConveniences() {
        return convenienceService.getAllConveniences();
    }

    @GetMapping("/{id}")
    public Convenience getConvenienceById(@PathVariable Long id) {
        return convenienceService.getConvenienceById(id);
    }

    @PostMapping
    public Convenience createConvenience(@RequestBody Convenience convenience) {
        return convenienceService.createConvenience(convenience);
    }

    @PutMapping("/{id}")
    public Convenience updateConvenience(@PathVariable Long id, @RequestBody Convenience convenience) {
        return convenienceService.updateConvenience(id, convenience);
    }

    @DeleteMapping("/{id}")
    public void deleteConvenience(@PathVariable Long id) {
        convenienceService.deleteConvenience(id);
    }
}
