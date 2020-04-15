package pl.jakubtrzcinski.swapireporter.swapiclient.dto;

import lombok.Data;

import java.net.URL;
import java.util.List;
import java.util.Optional;

@Data
public class SwapiPage<T> {
    private int count;
    private URL next;
    private URL previous;
    private List<T> results;

    public Optional<URL> getNext(){
        return Optional.ofNullable(next);
    }
}
