package com.vshumick.task.kyiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vshumick.task.kyiv.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
