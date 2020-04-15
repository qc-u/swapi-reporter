package pl.jakubtrzcinski.swapireporter.swapiclient;

import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Film;

import java.net.URL;

interface FilmService {
    Film getOne(URL url);
}
