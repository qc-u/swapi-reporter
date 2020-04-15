
package pl.jakubtrzcinski.swapireporter.swapiclient.dto;

import lombok.Builder;
import lombok.Data;

import java.net.URL;
import java.util.List;

@Data
@Builder
@SuppressWarnings("unused")
public class Film {

    private String created;
    private String director;
    private String edited;
    private long episodeId;
    private String openingCrawl;
    private String producer;
    private String releaseDate;
    private String title;

    private URL url;
    private List<URL> characters;
    private List<URL> planets;
    private List<URL> vehicles;
    private List<URL> species;
    private List<URL> starships;

}
