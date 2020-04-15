package pl.jakubtrzcinski.swapireporter.report;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface ReportEntityRepository extends JpaRepository<ReportEntity, UUID> {
}
