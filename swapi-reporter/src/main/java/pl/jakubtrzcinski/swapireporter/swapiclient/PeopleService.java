package pl.jakubtrzcinski.swapireporter.swapiclient;

import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Person;

import java.util.List;

interface PeopleService {
    List<Person> findAllByPhrase(String phrase);
}
