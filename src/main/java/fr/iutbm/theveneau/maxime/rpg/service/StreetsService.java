package fr.iutbm.theveneau.maxime.rpg.service;

import fr.iutbm.theveneau.maxime.rpg.model.DTO.StreetDTO;
import fr.iutbm.theveneau.maxime.rpg.repository.StreetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StreetsService {
    private StreetsRepository streetsRepository;

    @Autowired
    public void StreetsRepository(StreetsRepository streetsRepository){
        this.streetsRepository = streetsRepository;
    }

    public List<StreetDTO> getAllStreets() {
        return streetsRepository.findAll().stream()
                .map(StreetDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<StreetDTO> getStreetById(Long id) {
        return streetsRepository.findById(id)
                .map(StreetDTO::fromEntity);
    }

    public Optional<StreetDTO> getStreetByName(String name) {
        return streetsRepository.findByName(name)
                .map(StreetDTO::fromEntity);
    }
}
