package pl.jakubtrzcinski.swapireporter.report;

import pl.jakubtrzcinski.swapireporter.report.dto.StartwarsReport;
import pl.jakubtrzcinski.swapireporter.report.exception.ReportNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class InMemoryStartwarsReportRepository implements StartwarsReportRepository {
    private Map<UUID, StartwarsReport> map = new HashMap<>();
    @Override
    public void save(StartwarsReport report) {
        map.put(report.getId(), report);
    }

    @Override
    public StartwarsReport getOne(UUID id) {
        if(!map.containsKey(id)){
            throw new ReportNotFoundException(String.format("Report with id: %s could not be found.", id));
        }
        return map.get(id);
    }

    @Override
    public void delete(UUID id) {
        map.remove(id);
    }
}
