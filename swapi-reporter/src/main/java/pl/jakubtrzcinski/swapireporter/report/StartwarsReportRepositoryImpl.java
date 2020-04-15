package pl.jakubtrzcinski.swapireporter.report;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.jakubtrzcinski.swapireporter.report.dto.StartwarsReport;
import pl.jakubtrzcinski.swapireporter.report.exception.ReportNotFoundException;

import java.util.UUID;

@Primary
@Component
@RequiredArgsConstructor
class StartwarsReportRepositoryImpl implements StartwarsReportRepository {

    private final Gson gson;

    private final ReportEntityRepository reportEntityRepository;

    @Override
    public void save(StartwarsReport report) {
        reportEntityRepository.save(new ReportEntity(report.getId(), gson.toJson(report)));
    }

    @Override
    public StartwarsReport getOne(UUID id) {
        return gson.fromJson(getEntity(id).getReportData(), StartwarsReport.class);
    }

    @Override
    public void delete(UUID id) {
        reportEntityRepository.deleteById(id);
    }

    private ReportEntity getEntity(UUID id) {
        return reportEntityRepository.findById(id).orElseThrow(() -> new ReportNotFoundException(String.format("Report with id: %s could not be found.", id)));
    }
}
