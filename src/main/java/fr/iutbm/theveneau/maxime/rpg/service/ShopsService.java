package fr.iutbm.theveneau.maxime.rpg.service;

import fr.iutbm.theveneau.maxime.rpg.model.DTO.ShopDTO;
import fr.iutbm.theveneau.maxime.rpg.repository.ShopsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopsService {
    private ShopsRepository shopsRepository;

    @Autowired
    public void ShopsRepository(ShopsRepository shopsRepository){
        this.shopsRepository = shopsRepository;
    }

    public List<ShopDTO> getAllShops() {
        return shopsRepository.findAll().stream()
                .map(ShopDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<ShopDTO> getShopById(Long id) {
        return shopsRepository.findById(id)
                .map(ShopDTO::fromEntity);
    }

    public Optional<ShopDTO> getShopByName(String name) {
        return shopsRepository.findByName(name)
                .map(ShopDTO::fromEntity);
    }
}
