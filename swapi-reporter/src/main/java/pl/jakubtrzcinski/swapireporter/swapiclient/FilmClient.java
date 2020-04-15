package pl.jakubtrzcinski.swapireporter.swapiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Film;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.SwapiPage;

@FeignClient(value = "film", url = "http://localhost:8080/api/films")
interface FilmClient {

    @GetMapping(value = "/{id}", produces = "application/json")
    Film getOne(@PathVariable("id") int id);

    @GetMapping(produces = "application/json")
    SwapiPage<Film> getPage(@RequestParam("page") int page);


}
