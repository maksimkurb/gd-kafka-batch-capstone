package ru.cubly.pet.consumer.component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cubly.pet.model.HddReport;
import ru.cubly.pet.model.HddReportId;

@Repository
public interface HddReportRepository extends JpaRepository<HddReport, HddReportId> {
}
