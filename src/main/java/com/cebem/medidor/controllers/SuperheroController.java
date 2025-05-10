package com.cebem.medidor.controllers;

import org.springframework.web.bind.annotation.*;

import com.cebem.medidor.models.Superhero;
import com.cebem.medidor.services.SuperheroService;

@RestController
@RequestMapping("/api/superheroes")
public class SuperheroController {

    private final SuperheroService service;

    public SuperheroController(SuperheroService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Superhero getSuperhero(@PathVariable String id) {
        return service.getSuperheroById(id);
    }
}
