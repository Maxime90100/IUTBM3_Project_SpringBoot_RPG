package fr.iutbm.theveneau.maxime.rpg.repository;

import fr.iutbm.theveneau.maxime.rpg.model.Shop;
import fr.iutbm.theveneau.maxime.rpg.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShopsRepository extends JpaRepository<Shop,Long> {
    Optional<Shop> findByName(String name);
    List<Shop> findAllByStreet(Street street);
}
