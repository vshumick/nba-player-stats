package com.vshumick.task.kyiv.service;

import com.vshumick.task.kyiv.dto.PlayerSeasonAverageStatsDTO;
import com.vshumick.task.kyiv.dto.TeamSeasonAverageStatsDTO;
import com.vshumick.task.kyiv.model.Statistics;
import com.vshumick.task.kyiv.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    public List<Statistics> getAllStatistics() {
        return statisticsRepository.findAll();
    }

    public Optional<Statistics> getStatisticsById(Long id) {
        return statisticsRepository.findById(id);
    }

    public Statistics addNewStatistics(Statistics statistics) {
        return statisticsRepository.save(statistics);
    }

    public Statistics updateStatistics(Long id, Statistics statisticsDetails) {
        Statistics statistics = statisticsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Statistics not found"));
        return statisticsRepository.save(statistics);
    }

    public void deleteStatisticsById(Long id) {
        statisticsRepository.deleteById(id);
    }

    public List<PlayerSeasonAverageStatsDTO> getAverageStatisticsByPlayerId(Long playerId) {
        return statisticsRepository.findAverageStatisticsByPlayerId(playerId);
    }

    public List<TeamSeasonAverageStatsDTO> getAverageStatisticsByTeam(Long teamId) {
        return statisticsRepository.findAverageStatisticsByTeamId(teamId);
    }
}
