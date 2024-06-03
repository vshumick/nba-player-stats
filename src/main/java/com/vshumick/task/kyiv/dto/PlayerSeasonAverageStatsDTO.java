package com.vshumick.task.kyiv.dto;

import lombok.Data;

@Data
public class PlayerSeasonAverageStatsDTO {
    private String season;
    private String playerName;
    private Long playerId;
    private Double point;
    private Double rebound;
    private Double assist;
    private Double steal;
    private Double block;
    private Double foul;
    private Double turnover;
    private Double playedMinute;

    public PlayerSeasonAverageStatsDTO(String season, String playerName, Long playerId, Double point, Double rebound, Double assist, Double steal, Double block, Double foul, Double turnover, Double playedMinute) {
        this.season = season;
        this.playerName = playerName;
        this.playerId = playerId;
        this.point = point;
        this.rebound = rebound;
        this.assist = assist;
        this.steal = steal;
        this.block = block;
        this.foul = foul;
        this.turnover = turnover;
        this.playedMinute = playedMinute;
    }

    // Геттеры и сеттеры
}
