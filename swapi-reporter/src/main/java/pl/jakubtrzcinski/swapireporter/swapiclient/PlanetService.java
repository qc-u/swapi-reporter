package pl.jakubtrzcinski.swapireporter.swapiclient;

import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Planet;

import java.util.Optional;

interface PlanetService {
    Optional<Planet> findByName(String planetName);
}
