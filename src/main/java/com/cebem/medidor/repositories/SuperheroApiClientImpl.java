package com.cebem.medidor.repositories;

import com.cebem.medidor.models.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

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
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl + id).toUriString();

        try {
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

            if (response.getStatusCode().is2xxSuccessful() && "success".equals(response.getBody().get("response"))) {
                Map<String, Object> body = response.getBody();
                Superhero hero = new Superhero();
                hero.setId((String) body.get("id"));
                hero.setName((String) body.get("name"));

                // Mapeamos la imagen
                Map<String, String> image = (Map<String, String>) body.get("image");
                Superhero.Image img = new Superhero.Image();
                img.setUrl(image.get("url"));
                hero.setImage(img);

                return hero;
            }
        } catch (Exception e) {
            System.out.println("Error al obtener superhéroe con ID " + id + ": " + e.getMessage());
        }

        return null; // Si hay error o no es success
    }
}
