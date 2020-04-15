package pl.jakubtrzcinski.swapireporter.report;

import pl.jakubtrzcinski.swapireporter.report.dto.StartwarsReport;
import pl.jakubtrzcinski.swapireporter.report.dto.StarwarsReportQuery;

import java.util.UUID;

public interface StarwarsReportFacade {
    void create(UUID id, StarwarsReportQuery query);
    StartwarsReport getOne(UUID id);
    void delete(UUID id);
}
