package ru.cubly.pet.analyzer.component;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cubly.pet.model.AnalyticsByModel;


@org.springframework.stereotype.Repository
public interface AnalyticsByModelRepository extends JpaRepository<AnalyticsByModel, String> {
}
