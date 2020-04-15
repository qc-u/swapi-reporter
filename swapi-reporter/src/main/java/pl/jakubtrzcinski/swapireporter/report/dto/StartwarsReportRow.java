package pl.jakubtrzcinski.swapireporter.report.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StartwarsReportRow {

    @JsonProperty("film_id")
    private int filmId;
    @JsonProperty("film_name")
    private String filmName;

    @JsonProperty("character_id")
    private int characterId;
    @JsonProperty("character_name")
    private String characterName;

    @JsonProperty("planet_id")
    private int planetId;
    @JsonProperty("planet_name")
    private String planetName;
}
