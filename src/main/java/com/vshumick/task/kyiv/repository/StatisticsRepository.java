package com.vshumick.task.kyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vshumick.task.kyiv.model.Statistics;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
}
