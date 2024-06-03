package com.vshumick.task.kyiv.controller;

import com.vshumick.task.kyiv.dto.PlayerSeasonAverageStatsDTO;
import com.vshumick.task.kyiv.dto.TeamSeasonAverageStatsDTO;
import com.vshumick.task.kyiv.model.Statistics;
import com.vshumick.task.kyiv.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsRestController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping
    public List<Statistics> getAllStatistics() {
        return statisticsService.getAllStatistics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statistics> getStatisticsById(@PathVariable Long id) {
        Optional<Statistics> statistics = statisticsService.getStatisticsById(id);
        return statistics.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Statistics createStatistics(@RequestBody Statistics statistics) {
        return statisticsService.addNewStatistics(statistics);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Statistics> updateStatistics(@PathVariable Long id, @RequestBody Statistics statisticsDetails) {
        try {
            Statistics updatedStatistics = statisticsService.updateStatistics(id, statisticsDetails);
            return ResponseEntity.ok(updatedStatistics);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatistics(@PathVariable Long id) {
        Optional<Statistics> optionalStatistics = statisticsService.getStatisticsById(id);
        if (optionalStatistics.isPresent()) {
            statisticsService.deleteStatisticsById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/average/player/{playerId}")
    public List<PlayerSeasonAverageStatsDTO> getAverageStatistics(@PathVariable Long playerId) {
        return statisticsService.getAverageStatisticsByPlayerId(playerId);
    }

    @GetMapping("/average/team/{teamId}")
    public List<TeamSeasonAverageStatsDTO> getAverageStatisticsByTeam(@PathVariable Long teamId) {
        return statisticsService.getAverageStatisticsByTeam(teamId);
    }
}
