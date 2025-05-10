package com.cebem.medidor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cebem.medidor.models.Superhero;
import com.cebem.medidor.services.SuperheroService;

@Controller
@RequestMapping("/api/superheroes")
public class SuperheroController {

    private final SuperheroService service;

    public SuperheroController(SuperheroService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getSuperhero(@PathVariable String id, Model model) {
        Superhero superhero = service.getSuperheroById(id);
        model.addAttribute("superhero", superhero);
        return "superhero"; // Thymeleaf HTML: templates/superhero.html
    }

    @GetMapping("/random")
    public String getRandomSuperhero(Model model) {
        Superhero superhero = service.getRandomSuperhero();
        model.addAttribute("superhero", superhero);
        return "superhero"; // Reutiliza la misma vista
    }
}
