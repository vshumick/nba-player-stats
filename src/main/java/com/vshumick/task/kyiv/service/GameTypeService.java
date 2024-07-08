package com.vshumick.task.kyiv.service;

import com.vshumick.task.kyiv.model.GameType;
import com.vshumick.task.kyiv.repository.GameTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameTypeService {

    @Autowired
    private GameTypeRepository gameTypeRepository;

    public List<GameType> getAllGameTypes() {
        return gameTypeRepository.findAll();
    }

    public Optional<GameType> getGameTypeById(Long id) {
        return gameTypeRepository.findById(id);
    }

    public GameType addNewGameType(GameType gameType) {
        return gameTypeRepository.save(gameType);
    }

    public void deleteGameTypeById(Long id) {
        gameTypeRepository.deleteById(id);
    }

    public GameType updateGameType(Long id, GameType gameTypeDetails) {
        Optional<GameType> optionalGameType = gameTypeRepository.findById(id);
        if (optionalGameType.isPresent()) {
            GameType gameType = optionalGameType.get();
            gameType.setName(gameTypeDetails.getName());
            gameType.setDescription(gameTypeDetails.getDescription());
            return gameTypeRepository.save(gameType);
        } else {
            throw new RuntimeException("GameType not found with id " + id);
        }
    }
}
