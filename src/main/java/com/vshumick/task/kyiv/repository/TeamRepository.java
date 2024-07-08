package com.vshumick.task.kyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vshumick.task.kyiv.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
