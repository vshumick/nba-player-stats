package com.vshumick.task.kyiv.repository;

import com.vshumick.task.kyiv.dto.PlayerSeasonAverageStatsDTO;
import com.vshumick.task.kyiv.dto.TeamSeasonAverageStatsDTO;
import com.vshumick.task.kyiv.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

     @Query("SELECT new com.vshumick.task.kyiv.dto.PlayerSeasonAverageStatsDTO(s2.name, p.name, s.player.id, AVG(s.point), AVG(s.rebound), AVG(s.assist), AVG(s.steal), AVG(s.block), AVG(s.foul), AVG(s.turnover), AVG(s.playedMinute)) " +
            "FROM Statistics s " +
            "JOIN s.player p " +
            "JOIN s.game g " +
            "JOIN g.season s2 " +
            "WHERE s.player.id = :playerId " +
            "GROUP BY s2.name, s.player.id, p.name " +
            "ORDER BY s2.name, p.name")
    List<PlayerSeasonAverageStatsDTO> findAverageStatisticsByPlayerId(@Param("playerId") Long playerId);

    @Query("SELECT new com.vshumick.task.kyiv.dto.TeamSeasonAverageStatsDTO(s2.name, t.name, p.team.id, AVG(s.point), AVG(s.rebound), AVG(s.assist), AVG(s.steal), AVG(s.block), AVG(s.foul), AVG(s.turnover), AVG(s.playedMinute)) " +
            "FROM Statistics s " +
            "JOIN s.player p " +
            "JOIN p.team t " +
            "JOIN s.game g " +
            "JOIN g.season s2 " +
            "WHERE p.team.id = :teamId " +
            "GROUP BY s2.name, p.team.id, t.name " +
            "ORDER BY s2.name, p.team.id")
    List<TeamSeasonAverageStatsDTO> findAverageStatisticsByTeamId(@Param("teamId") Long teamId);


}
