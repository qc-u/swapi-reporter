package pl.jakubtrzcinski.swapireporter.report;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.jakubtrzcinski.swapireporter.report.dto.StartwarsReport;
import pl.jakubtrzcinski.swapireporter.report.dto.StartwarsReportRow;
import pl.jakubtrzcinski.swapireporter.report.dto.StarwarsReportQuery;
import pl.jakubtrzcinski.swapireporter.report.exception.ReportException;
import pl.jakubtrzcinski.swapireporter.swapiclient.StartwarsFacade;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Film;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Person;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Planet;
import pl.jakubtrzcinski.swapireporter.util.URLUtil;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class StarwarsReportDataProviderImpl implements StarwarsReportDataProvider {

    private final StartwarsFacade startwarsFacade;

    @Override
    public StartwarsReport generate(UUID id, StarwarsReportQuery query) {
        final List<Person> people = startwarsFacade.findAllPeopleByPhrase(query.getCharacterPhrase());
        final Planet planet = startwarsFacade.findPlanetByName(query.getPlanetName()).orElseThrow(()->new ReportException(String.format("Planet '%s' not found", query.getPlanetName())));

        Set<URL> filmsUrl = new HashSet<>();
        for (Person person : people) {
            for (URL film : person.getFilms()) {
                if(planet.getFilms().contains(film)){
                    filmsUrl.add(film);
                }
            }
        }
        final List<Film> films = filmsUrl.stream().map(startwarsFacade::getOneFilm).collect(Collectors.toList());

        List<StartwarsReportRow> rows = new LinkedList<>();
        for (Film film : films) {
            for (Person person : people) {
                rows.add(new StartwarsReportRow(
                        URLUtil.getId(film.getUrl()),
                        film.getTitle(),
                        URLUtil.getId(person.getUrl()),
                        person.getName(),
                        URLUtil.getId(planet.getUrl()),
                        planet.getName()
                ));
            }
        }
        return new StartwarsReport(
                id,
                query.getCharacterPhrase(),
                query.getPlanetName(),
                rows
        );
    }
}
