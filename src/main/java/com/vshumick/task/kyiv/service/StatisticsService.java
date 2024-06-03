package com.vshumick.task.kyiv.service;

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

    public void deleteStatisticsById(Long id) {
        statisticsRepository.deleteById(id);
    }

    public Statistics updateStatistics(Long id, Statistics statisticsDetails) {
        Optional<Statistics> optionalStatistics = statisticsRepository.findById(id);
        if (optionalStatistics.isPresent()) {
            Statistics statistics = optionalStatistics.get();
            statistics.setPlayer(statisticsDetails.getPlayer());
            statistics.setGame(statisticsDetails.getGame());
            statistics.setPoint(statisticsDetails.getPoint());
            statistics.setRebound(statisticsDetails.getRebound());
            statistics.setAssist(statisticsDetails.getAssist());
            statistics.setSteal(statisticsDetails.getSteal());
            statistics.setBlock(statisticsDetails.getBlock());
            statistics.setFoul(statisticsDetails.getFoul());
            statistics.setTurnover(statisticsDetails.getTurnover());
            statistics.setPlayedMinute(statisticsDetails.getPlayedMinute());
            return statisticsRepository.save(statistics);
        } else {
            throw new RuntimeException("Statistics not found with id " + id);
        }
    }
}
