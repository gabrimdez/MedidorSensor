package com.cebem.medidor.repositories;

import com.cebem.medidor.models.Superhero;

public interface SuperheroApiClient {
    Superhero getSuperheroById(String id);
}
