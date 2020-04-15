package pl.jakubtrzcinski.swapireporter.swapiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Person;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.SwapiPage;

@FeignClient(value = "people", url = "http://localhost:8080/api/people")
interface PeopleClient {

    @GetMapping(value = "/{id}", produces = "application/json")
    Person getOne(@PathVariable("id") int id);

    @GetMapping(produces = "application/json")
    SwapiPage<Person> getPage(@RequestParam("page") int page);

}
