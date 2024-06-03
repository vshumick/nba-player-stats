package com.vshumick.task.kyiv.dto;

import lombok.Data;

@Data
public class TeamSeasonAverageStatsDTO {
    private String season;
    private String teamName;
    private Long teamId;
    private Double point;
    private Double rebound;
    private Double assist;
    private Double steal;
    private Double block;
    private Double foul;
    private Double turnover;
    private Double playedMinute;

    public TeamSeasonAverageStatsDTO(String season, String teamName, Long teamId, Double point, Double rebound, Double assist, Double steal, Double block, Double foul, Double turnover, Double playedMinute) {
        this.season = season;
        this.teamName = teamName;
        this.teamId = teamId;
        this.point = point;
        this.rebound = rebound;
        this.assist = assist;
        this.steal = steal;
        this.block = block;
        this.foul = foul;
        this.turnover = turnover;
        this.playedMinute = playedMinute;
    }

    // Getters and setters
}
