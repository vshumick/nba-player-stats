package com.vshumick.task.kyiv.controller;

import com.vshumick.task.kyiv.model.Game;
import com.vshumick.task.kyiv.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class GameRestController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        Optional<Game> game = gameService.getGameById(id);
        return game.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameService.addNewGame(game);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game gameDetails) {
        try {
            Game updatedGame = gameService.updateGame(id, gameDetails);
            return ResponseEntity.ok(updatedGame);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        Optional<Game> optionalGame = gameService.getGameById(id);
        if (optionalGame.isPresent()) {
            gameService.deleteGameById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
