package pl.jakubtrzcinski.swapireporter.swapiclient;

import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Film;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Person;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Planet;

import java.net.URL;
import java.util.List;
import java.util.Optional;

public interface StartwarsFacade {
    Film getOneFilm(URL url);
    List<Person> findAllPeopleByPhrase(String phrase);
    Optional<Planet> findPlanetByName(String planetName);
}
