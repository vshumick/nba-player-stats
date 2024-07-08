package com.vshumick.task.kyiv.service;

import com.vshumick.task.kyiv.model.Game;
import com.vshumick.task.kyiv.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    public Game addNewGame(Game game) {
        return gameRepository.save(game);
    }

    public void deleteGameById(Long id) {
        gameRepository.deleteById(id);
    }

    public Game updateGame(Long id, Game gameDetails) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            game.setDate(gameDetails.getDate());
            game.setSeason(gameDetails.getSeason());
            game.setHomeTeam(gameDetails.getHomeTeam());
            game.setAwayTeam(gameDetails.getAwayTeam());
            game.setType(gameDetails.getType());
            return gameRepository.save(game);
        } else {
            throw new RuntimeException("Game not found with id " + id);
        }
    }
}
