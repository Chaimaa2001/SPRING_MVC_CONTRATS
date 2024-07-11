package com.ad.spring_mvc.web;

import com.ad.spring_mvc.entities.Contrat;
import com.ad.spring_mvc.repositories.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContratRestAPI {
    @Autowired
    private ContratRepository contratRepository;
    @GetMapping("/contrats")
    public List<Contrat> contrats()
    {
        return contratRepository.findAll();
    }
    @GetMapping("/contrats/{id}")
    public Contrat contrats(@PathVariable  Long id)
    {
        return contratRepository.findById(id).get();
    }
    @PostMapping("/contrats")
    public Contrat save(@RequestBody Contrat contrat)
    {
        return contratRepository.save(contrat);
    }
    @PutMapping("/contrats/{id}")
    public Contrat update(@RequestBody Contrat contrat,@PathVariable Long id)
    {
        contrat.setId(id);
        return contratRepository.save(contrat);
    }
    @DeleteMapping("/contrats/{id}")
    public void delete(@PathVariable Long id)
    {
        contratRepository.deleteById(id);
    }
}
