package com.vshumick.task.kyiv.service;

import com.vshumick.task.kyiv.model.Season;
import com.vshumick.task.kyiv.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }

    public Optional<Season> getSeasonById(Long id) {
        return seasonRepository.findById(id);
    }

    public Season addNewSeason(Season season) {
        return seasonRepository.save(season);
    }

    public void deleteSeasonById(Long id) {
        seasonRepository.deleteById(id);
    }

    public Season updateSeason(Long id, Season seasonDetails) {
        Optional<Season> optionalSeason = seasonRepository.findById(id);
        if (optionalSeason.isPresent()) {
            Season season = optionalSeason.get();
            season.setName(seasonDetails.getName());
            return seasonRepository.save(season);
        } else {
            throw new RuntimeException("Season not found with id " + id);
        }
    }
}
