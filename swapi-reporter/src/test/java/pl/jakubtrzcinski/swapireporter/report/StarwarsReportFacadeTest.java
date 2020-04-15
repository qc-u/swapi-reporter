package pl.jakubtrzcinski.swapireporter.report;

import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.jakubtrzcinski.swapireporter.report.dto.StartwarsReport;
import pl.jakubtrzcinski.swapireporter.report.dto.StartwarsReportRow;
import pl.jakubtrzcinski.swapireporter.report.dto.StarwarsReportQuery;
import pl.jakubtrzcinski.swapireporter.swapiclient.StartwarsFacade;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Film;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Person;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Planet;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StarwarsReportFacadeTest {

    StartwarsFacade startwarsFacade = mock(StartwarsFacade.class);

    StarwarsReportFacade facade = new StarwarsReportFacadeImpl(
            new InMemoryStartwarsReportRepository(),
            new StarwarsReportDataProviderImpl(
                    startwarsFacade
            )
    );


    @SneakyThrows(MalformedURLException.class)
    @Test
    void create() {

        //given
        String planet = "Yavin IV";
        String phrase = "Luke";
        List<Film> films = List.of(
                Film.builder().url(new URL("http://localhost:8080/api/films/1")).title("Fancy film").build(),
                Film.builder().url(new URL("http://localhost:8080/api/films/2")).title("Fancy film 2").build(),
                Film.builder().url(new URL("http://localhost:8080/api/films/3")).title("FBoring film").build()
        );
        List<Person> peoples = List.of(
                Person.builder().url(new URL("http://localhost:8080/api/people/1")).name("Luke 1").build(),
                Person.builder().url(new URL("http://localhost:8080/api/people/2")).name("Luke 2").build()
        );
        List<Planet> planets = List.of(
                Planet.builder().url(new URL("http://localhost:8080/api/planets/1")).name("Yavin IV").build()
        );
        List<URL> planetsUrls = planets.stream().map(Planet::getUrl).collect(Collectors.toList());
        films.get(0).setPlanets(planetsUrls);
        films.get(2).setPlanets(planetsUrls);

        List<URL> peopleUrls = peoples.stream().map(Person::getUrl).collect(Collectors.toList());
        films.get(0).setCharacters(peopleUrls);
        films.get(1).setCharacters(peopleUrls);
        films.get(2).setCharacters(peopleUrls);

        List<URL> filmsUrls = films.stream().map(Film::getUrl).collect(Collectors.toList());
        planets.get(0).setFilms(filmsUrls);
        peoples.get(0).setFilms(filmsUrls);
        peoples.get(1).setFilms(filmsUrls);

        when(startwarsFacade.findPlanetByName(planets.get(0).getName())).thenReturn(Optional.of(planets.get(0)));
        when(startwarsFacade.getOneFilm(films.get(0).getUrl())).thenReturn(films.get(0));
        when(startwarsFacade.getOneFilm(films.get(1).getUrl())).thenReturn(films.get(1));
        when(startwarsFacade.getOneFilm(films.get(2).getUrl())).thenReturn(films.get(2));
        when(startwarsFacade.findAllPeopleByPhrase(phrase)).thenReturn(peoples);

        //when
        UUID id = UUID.randomUUID();
        facade.create(id, new StarwarsReportQuery(phrase, planet));

        //then
        StartwarsReport report = facade.getOne(id);

        List<StartwarsReportRow> rows = report.getResult();

        assertEquals(6, rows.size());

        StartwarsReportRow row = rows.get(0);
        assertEquals("FBoring film", row.getFilmName());
        assertEquals(3, row.getFilmId());
        assertEquals("Luke 1", row.getCharacterName());
        assertEquals(1, row.getCharacterId());
        assertEquals("Yavin IV", row.getPlanetName());
        assertEquals(1, row.getPlanetId());


        row = rows.get(1);
        assertEquals("FBoring film", row.getFilmName());
        assertEquals(3, row.getFilmId());
        assertEquals("Luke 2", row.getCharacterName());
        assertEquals(2, row.getCharacterId());
        assertEquals("Yavin IV", row.getPlanetName());
        assertEquals(1, row.getPlanetId());

        row = rows.get(2);
        assertEquals("Fancy film", row.getFilmName());
        assertEquals(1, row.getFilmId());
        assertEquals("Luke 1", row.getCharacterName());
        assertEquals(1, row.getCharacterId());
        assertEquals("Yavin IV", row.getPlanetName());
        assertEquals(1, row.getPlanetId());

        row = rows.get(3);
        assertEquals("Fancy film", row.getFilmName());
        assertEquals(1, row.getFilmId());
        assertEquals("Luke 2", row.getCharacterName());
        assertEquals(2, row.getCharacterId());
        assertEquals("Yavin IV", row.getPlanetName());
        assertEquals(1, row.getPlanetId());

        row = rows.get(4);
        assertEquals("Fancy film 2", row.getFilmName());
        assertEquals(2, row.getFilmId());
        assertEquals("Luke 1", row.getCharacterName());
        assertEquals(1, row.getCharacterId());
        assertEquals("Yavin IV", row.getPlanetName());
        assertEquals(1, row.getPlanetId());

        row = rows.get(5);
        assertEquals("Fancy film 2", row.getFilmName());
        assertEquals(2, row.getFilmId());
        assertEquals("Luke 2", row.getCharacterName());
        assertEquals(2, row.getCharacterId());
        assertEquals("Yavin IV", row.getPlanetName());
        assertEquals(1, row.getPlanetId());
    }

    @Test
    void getOne() {
    }

    @Test
    void delete() {
    }
}
