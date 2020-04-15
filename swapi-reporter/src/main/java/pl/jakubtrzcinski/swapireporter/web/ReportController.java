package pl.jakubtrzcinski.swapireporter.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.jakubtrzcinski.swapireporter.report.StarwarsReportFacade;
import pl.jakubtrzcinski.swapireporter.report.dto.StartwarsReport;
import pl.jakubtrzcinski.swapireporter.report.dto.StarwarsReportQuery;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
class ReportController {

    private final StarwarsReportFacade reportFacade;

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void put(@PathVariable("id") UUID id, @RequestBody @Valid StarwarsReportQuery query) {
        reportFacade.create(id, query);
    }

    @GetMapping("/{id}")
    public StartwarsReport get(@PathVariable("id") UUID id) {
        return reportFacade.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        reportFacade.delete(id);
    }
}
