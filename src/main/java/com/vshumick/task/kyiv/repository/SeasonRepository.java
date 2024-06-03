package com.vshumick.task.kyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vshumick.task.kyiv.model.Season;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
