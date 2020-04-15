package pl.jakubtrzcinski.swapireporter.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class ReportEntity {
    @Id
    private UUID id;

    @Column(name="report_data", length = 10000)
    private String reportData;
}
