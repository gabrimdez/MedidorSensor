package com.cebem.medidor.services;

import org.springframework.stereotype.Service;
import com.cebem.medidor.models.Superhero;
import com.cebem.medidor.repositories.SuperheroApiClient;

@Service
public class SuperheroService {

    private final SuperheroApiClient apiClient;

    public SuperheroService(SuperheroApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Superhero getSuperheroById(String id) {
        return apiClient.getSuperheroById(id); // ← Esta es la llamada real
    }
}
