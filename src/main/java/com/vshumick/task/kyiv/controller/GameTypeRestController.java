package com.vshumick.task.kyiv.controller;

import com.vshumick.task.kyiv.model.GameType;
import com.vshumick.task.kyiv.service.GameTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/game-types")
public class GameTypeRestController {

    @Autowired
    private GameTypeService gameTypeService;

    @GetMapping
    public List<GameType> getAllGameTypes() {
        return gameTypeService.getAllGameTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameType> getGameTypeById(@PathVariable Long id) {
        Optional<GameType> gameType = gameTypeService.getGameTypeById(id);
        return gameType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public GameType createGameType(@RequestBody GameType gameType) {
        return gameTypeService.addNewGameType(gameType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameType> updateGameType(@PathVariable Long id, @RequestBody GameType gameTypeDetails) {
        try {
            GameType updatedGameType = gameTypeService.updateGameType(id, gameTypeDetails);
            return ResponseEntity.ok(updatedGameType);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGameType(@PathVariable Long id) {
        Optional<GameType> optionalGameType = gameTypeService.getGameTypeById(id);
        if (optionalGameType.isPresent()) {
            gameTypeService.deleteGameTypeById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
