package pl.jakubtrzcinski.swapireporter.report.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StarwarsReportQuery {
    @NotEmpty
    @JsonProperty("query_criteria_character_phrase")
    private String characterPhrase;

    @NotEmpty
    @JsonProperty("query_criteria_planet_name")
    private String planetName;
}
