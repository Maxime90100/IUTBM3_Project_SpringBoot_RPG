package fr.iutbm.theveneau.maxime.rpg.service;

import fr.iutbm.theveneau.maxime.rpg.model.ItemCategory;
import fr.iutbm.theveneau.maxime.rpg.repository.ItemCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemCategoriesService {
    private ItemCategoriesRepository itemCategoryRepository;

    @Autowired
    public ItemCategoriesService(ItemCategoriesRepository itemCategoryRepository){
        this.itemCategoryRepository = itemCategoryRepository;
    }

    public List<ItemCategory> getAllCategories(){
        return itemCategoryRepository.findAll();
    }
    public Optional<ItemCategory> getCategoryByName(String name){
        return itemCategoryRepository.findByName(name);
    }
    public void createCategory(String name){
        ItemCategory newCategory = new ItemCategory(name);
        List<ItemCategory> categories = itemCategoryRepository.findAll();
        if(!categories.contains(newCategory))
            itemCategoryRepository.save(newCategory);
        else
            System.out.println(String.format("'%s' already exist.",newCategory));
    }
}
