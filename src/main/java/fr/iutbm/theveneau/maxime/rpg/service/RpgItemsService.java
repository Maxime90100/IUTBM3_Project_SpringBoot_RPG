package fr.iutbm.theveneau.maxime.rpg.service;

import fr.iutbm.theveneau.maxime.rpg.model.ItemCategory;
import fr.iutbm.theveneau.maxime.rpg.model.RpgItem;
import fr.iutbm.theveneau.maxime.rpg.repository.RpgItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RpgItemsService {
    private RpgItemsRepository rpgItemRepository;
    private ItemCategoriesService itemCategoryService;

    @Autowired
    public RpgItemsService(RpgItemsRepository rpgItemRepository, ItemCategoriesService itemCategoryService) {
        this.rpgItemRepository = rpgItemRepository;
        this.itemCategoryService = itemCategoryService;
    }

    public List<RpgItem> getAllItems() {
        return rpgItemRepository.findAll();
    }
    public Optional<RpgItem> getItemById(Long id) {
        return rpgItemRepository.findById(id);
    }
    public List<RpgItem> getItemsByCategory(String cat) {
        Optional<ItemCategory> category = itemCategoryService.getCategoryByName(cat);
        return category.map(itemCategory -> rpgItemRepository.findAllByCategory(itemCategory)).orElse(null);
    }
    public List<RpgItem> getItemsByCategoryUnderPrice(String cat, double price) {
        Optional<ItemCategory> category = itemCategoryService.getCategoryByName(cat);
        return category.map(itemCategory -> rpgItemRepository.findAllByCategoryAndPriceLessThan(itemCategory, price)).orElse(null);
    }
    public List<RpgItem>getItemsNameContaining(List<String> patterns) {
        List<RpgItem> items = new ArrayList<>();
        patterns.forEach(pattern -> {
            items.addAll(rpgItemRepository.findAllByNameContaining(pattern));
        });
        return items;
    }
    public List<RpgItem> getItemsNoEffect() {
        return rpgItemRepository.findAllByEffectIsNull();
    }
    public void createItem(String name, String cat, double price, String effect) {
        Optional<ItemCategory> category = itemCategoryService.getCategoryByName(cat);
        ItemCategory itemCategory = category.orElseThrow(() -> new IllegalArgumentException("Category not found: " + cat));
        rpgItemRepository.save(new RpgItem(name, itemCategory, price, effect));
    }
}
