package pl.jakubtrzcinski.swapireporter.report;

import pl.jakubtrzcinski.swapireporter.report.dto.StartwarsReport;

import java.util.UUID;

interface StartwarsReportRepository {
    void save(StartwarsReport report);
    StartwarsReport getOne(UUID id);
    void delete(UUID id);
}
