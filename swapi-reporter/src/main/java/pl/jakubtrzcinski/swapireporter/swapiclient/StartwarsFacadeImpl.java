package pl.jakubtrzcinski.swapireporter.swapiclient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Film;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Person;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Planet;

import java.net.URL;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class StartwarsFacadeImpl implements StartwarsFacade {

    private final FilmService filmService;
    private final PeopleService peopleService;
    private final PlanetService planetService;

    @Override
    public Film getOneFilm(URL url) {
        return filmService.getOne(url);
    }

    @Override
    public List<Person> findAllPeopleByPhrase(String phrase) {
        return peopleService.findAllByPhrase(phrase);
    }

    @Override
    public Optional<Planet> findPlanetByName(String planetName) {
        return planetService.findByName(planetName);
    }
}
