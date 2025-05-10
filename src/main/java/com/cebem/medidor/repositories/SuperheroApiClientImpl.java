package com.cebem.medidor.repositories;

import com.cebem.medidor.models.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class SuperheroApiClientImpl implements SuperheroApiClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public SuperheroApiClientImpl(@Value("${superhero.api.token}") String token) {
        this.restTemplate = new RestTemplate();
        this.baseUrl = "https://superheroapi.com/api/" + token + "/";
    }

    @Override
    public Superhero getSuperheroById(String id) {
        String url = baseUrl + id;
        return restTemplate.getForObject(url, Superhero.class);
    }
}
