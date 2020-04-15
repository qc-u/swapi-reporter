package pl.jakubtrzcinski.swapireporter.report;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.jakubtrzcinski.swapireporter.report.dto.StartwarsReport;
import pl.jakubtrzcinski.swapireporter.report.dto.StarwarsReportQuery;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class StarwarsReportFacadeImpl implements StarwarsReportFacade {

    private final StartwarsReportRepository reportRepository;

    private final StarwarsReportDataProvider dataProvider;

    @Override
    public void create(UUID id, StarwarsReportQuery query) {
        reportRepository.save(dataProvider.generate(id, query));
    }

    public StartwarsReport getOne(UUID id) {
        return reportRepository.getOne(id);
    }

    public void delete(UUID id) {
        reportRepository.delete(id);
    }
}
