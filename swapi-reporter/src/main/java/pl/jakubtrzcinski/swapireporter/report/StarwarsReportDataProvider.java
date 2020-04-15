package pl.jakubtrzcinski.swapireporter.report;


import pl.jakubtrzcinski.swapireporter.report.dto.StartwarsReport;
import pl.jakubtrzcinski.swapireporter.report.dto.StarwarsReportQuery;

import java.util.UUID;

interface StarwarsReportDataProvider {
    StartwarsReport generate(UUID id, StarwarsReportQuery query);
}
