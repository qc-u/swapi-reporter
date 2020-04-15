package pl.jakubtrzcinski.swapireporter.swapiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Planet;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.SwapiPage;


@FeignClient(value = "planet", url = "http://localhost:8080/api/planets")
interface PlanetClient {

    @GetMapping(value = "/{id}", produces = "application/json")
    Planet getOne(@PathVariable("id") int id);

    @GetMapping(produces = "application/json")
    SwapiPage<Planet> getPage(@RequestParam("page") int page);

}
