package com.cebem.medidor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cebem.medidor.models.Superhero;
import com.cebem.medidor.services.SuperheroService;

import java.util.Random;

@Controller
@RequestMapping("/superhero")
public class SuperheroViewController {

    @Autowired
    private SuperheroService superheroService;

    private final int MAX_HERO_ID = 731; // puedes ajustar esto si sabes el número exacto

    @GetMapping
    public String redirectToRandomHero() {
        int randomId = new Random().nextInt(MAX_HERO_ID) + 1; // de 1 a 731
        return "redirect:/superhero/view/" + randomId;
    }

    @GetMapping("/view")
    public String redirectToRandomHeroView() {
        int randomId = new Random().nextInt(MAX_HERO_ID) + 1;
        return "redirect:/superhero/view/" + randomId;
    }

    @GetMapping("/view/{id}")
    public String showSuperhero(@PathVariable String id, Model model) {
        Superhero superhero = superheroService.getSuperheroById(id);
        model.addAttribute("hero", superhero);
        return "superhero"; // nombre del archivo HTML sin la extensión
    }
}
