package fr.iutbm.theveneau.maxime.rpg.control;

import fr.iutbm.theveneau.maxime.rpg.model.ItemCategory;
import fr.iutbm.theveneau.maxime.rpg.service.ItemCategoriesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rpg")
public class ItemCategoriesController {
    private final ItemCategoriesService itemCategoryService;

    ItemCategoriesController(ItemCategoriesService itemCategoryService) {
        this.itemCategoryService = itemCategoryService;
    }

    @GetMapping("/categories")
    public List<ItemCategory> getAllCategories() {
        return itemCategoryService.getAllCategories();
    }

    @PostMapping("/categories/{name}")
    public void createCategrory(@PathVariable String name){
        itemCategoryService.createCategory(name);
    }
}
