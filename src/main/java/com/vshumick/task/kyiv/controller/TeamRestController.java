package com.vshumick.task.kyiv.controller;

import com.vshumick.task.kyiv.model.Team;
import com.vshumick.task.kyiv.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teams")
public class TeamRestController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        Optional<Team> team = teamService.getTeamById(id);
        return team.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.addNewTeam(team);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team teamDetails) {
        Optional<Team> optionalTeam = teamService.getTeamById(id);
        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            team.setName(teamDetails.getName());
            Team updatedTeam = teamService.addNewTeam(team);
            return ResponseEntity.ok(updatedTeam);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        Optional<Team> optionalTeam = teamService.getTeamById(id);
        if (optionalTeam.isPresent()) {
            teamService.deleteTeamById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
