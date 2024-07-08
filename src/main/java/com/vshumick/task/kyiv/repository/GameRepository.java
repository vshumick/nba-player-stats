package com.vshumick.task.kyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vshumick.task.kyiv.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
