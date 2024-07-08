package com.vshumick.task.kyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vshumick.task.kyiv.model.GameType;

public interface GameTypeRepository extends JpaRepository<GameType, Long> {
}
