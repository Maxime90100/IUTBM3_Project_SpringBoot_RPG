package fr.iutbm.theveneau.maxime.rpg.repository;

import fr.iutbm.theveneau.maxime.rpg.model.ItemCategory;
import fr.iutbm.theveneau.maxime.rpg.model.RpgItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RpgItemsRepository extends JpaRepository<RpgItem,Long> {

    List<RpgItem> findAllByCategory(ItemCategory category);
    List<RpgItem> findAllByCategoryAndPriceLessThan(ItemCategory category, double price);
    List<RpgItem> findAllByNameContaining(String pattern);
    List<RpgItem> findAllByEffectIsNull();
}
