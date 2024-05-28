package fr.iutbm.theveneau.maxime.rpg.repository;

import fr.iutbm.theveneau.maxime.rpg.model.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemCategoriesRepository extends JpaRepository<ItemCategory,Long> {
    Optional<ItemCategory> findByName(String name);
}
