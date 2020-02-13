package ru.cubly.pet.analyzer.component;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import ru.cubly.pet.model.HddReport;
import ru.cubly.pet.model.HddReportId;

@org.springframework.stereotype.Repository
public interface HddReportRepository extends Repository<HddReport, HddReportId> {
    @Query(value = "SELECT * FROM report r WHERE processed = false AND model = :model", nativeQuery = true)
    HddReport findAllUnprocessedByModel(String model);


}
