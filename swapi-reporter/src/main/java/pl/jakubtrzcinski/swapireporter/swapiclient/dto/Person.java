
package pl.jakubtrzcinski.swapireporter.swapiclient.dto;

import lombok.Builder;
import lombok.Data;

import java.net.URL;
import java.util.List;

@Data
@Builder
public class Person {

    private String birthYear;
    private String created;
    private String edited;
    private String eyeColor;
    private String gender;
    private String hairColor;
    private String height;
    private String homeworld;
    private String mass;
    private String name;
    private String skinColor;

    private List<URL> films;
    private List<URL> species;
    private List<URL> starships;
    private URL url;
    private List<URL> vehicles;

}
