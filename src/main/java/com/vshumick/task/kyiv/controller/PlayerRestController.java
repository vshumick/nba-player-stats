package com.vshumick.task.kyiv.controller;

import com.vshumick.task.kyiv.model.Player;
import com.vshumick.task.kyiv.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Optional<Player> player = playerService.getPlayerById(id);
        return player.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.addNewPlayer(player);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player playerDetails) {
        try {
            Player updatedPlayer = playerService.updatePlayer(id, playerDetails);
            return ResponseEntity.ok(updatedPlayer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        Optional<Player> optionalPlayer = playerService.getPlayerById(id);
        if (optionalPlayer.isPresent()) {
            playerService.deletePlayerById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
