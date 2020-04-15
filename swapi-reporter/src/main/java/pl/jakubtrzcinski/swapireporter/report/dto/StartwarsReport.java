package pl.jakubtrzcinski.swapireporter.report.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class StartwarsReport {
    @JsonProperty("report_id")
    private UUID id;
    @NotEmpty
    @JsonProperty("query_criteria_character_phrase")
    private String characterPhrase;

    @NotEmpty
    @JsonProperty("query_criteria_planet_name")
    private String planetName;

    private List<StartwarsReportRow> result;
}
