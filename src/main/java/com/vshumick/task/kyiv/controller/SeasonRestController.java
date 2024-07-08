package com.vshumick.task.kyiv.controller;

import com.vshumick.task.kyiv.model.Season;
import com.vshumick.task.kyiv.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seasons")
public class SeasonRestController {

    @Autowired
    private SeasonService seasonService;

    @GetMapping
    public List<Season> getAllSeasons() {
        return seasonService.getAllSeasons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Season> getSeasonById(@PathVariable Long id) {
        Optional<Season> season = seasonService.getSeasonById(id);
        return season.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Season createSeason(@RequestBody Season season) {
        return seasonService.addNewSeason(season);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Season> updateSeason(@PathVariable Long id, @RequestBody Season seasonDetails) {
        try {
            Season updatedSeason = seasonService.updateSeason(id, seasonDetails);
            return ResponseEntity.ok(updatedSeason);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeason(@PathVariable Long id) {
        Optional<Season> optionalSeason = seasonService.getSeasonById(id);
        if (optionalSeason.isPresent()) {
            seasonService.deleteSeasonById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
