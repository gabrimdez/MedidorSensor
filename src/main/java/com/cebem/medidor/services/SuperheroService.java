package com.cebem.medidor.services;

import org.springframework.stereotype.Service;
import com.cebem.medidor.models.Superhero;
import com.cebem.medidor.repositories.SuperheroApiClient;

import java.util.Random;

@Service
public class SuperheroService {

    private final SuperheroApiClient apiClient;
    private final Random random = new Random();

    public SuperheroService(SuperheroApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Superhero getSuperheroById(String id) {
        try {
            return apiClient.getSuperheroById(id);
        } catch (Exception e) {
            e.printStackTrace(); // aparecerá en los logs de Render
            return null;
        }
    }

    public Superhero getRandomSuperhero() {
        try {
            int randomId = random.nextInt(731) + 1; // IDs válidos entre 1 y 731
            return apiClient.getSuperheroById(String.valueOf(randomId));
        } catch (Exception e) {
            e.printStackTrace(); // para saber el motivo si falla
            return null;
        }
    }
}
