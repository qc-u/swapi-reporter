
package pl.jakubtrzcinski.swapireporter.swapiclient.dto;

import lombok.Builder;
import lombok.Data;

import java.net.URL;
import java.util.List;

@Data
@Builder
public class Planet {
    private String climate;
    private String created;
    private String diameter;
    private String edited;
    private String gravity;
    private String name;
    private String orbitalPeriod;
    private String population;
    private String rotationPeriod;
    private String surfaceWater;
    private String terrain;

    private URL url;
    private List<URL> films;
    private List<URL> residents;

}
