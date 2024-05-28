package fr.iutbm.theveneau.maxime.rpg.control;

import fr.iutbm.theveneau.maxime.rpg.model.DTO.RpgItemDTO;
import fr.iutbm.theveneau.maxime.rpg.model.RpgItem;
import fr.iutbm.theveneau.maxime.rpg.service.RpgItemsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rpg")
public class RpgItemsController {
    private final RpgItemsService rpgItemService;

    RpgItemsController(RpgItemsService rpgItemService) {
        this.rpgItemService = rpgItemService;
    }

    @GetMapping("/items")
    public List<RpgItem> getAllItems(
            @RequestParam(required = false) String like
    ) {
        if(like != null) return rpgItemService.getItemsNameContaining(List.of(like.split(",")));
        return rpgItemService.getAllItems();
    }
    @GetMapping("/items/noeffect")
    public List<RpgItem> getAllItemsWithoutEffect() {
        return rpgItemService.getItemsNoEffect();
    }
    @GetMapping("/items/{category}")
    public List<RpgItem> getAllItemsByCategory(
            @PathVariable String category,
            @RequestParam(required = false) Double maxPrice
    ) {
        if(maxPrice != null) return rpgItemService.getItemsByCategoryUnderPrice(category,maxPrice);
        return rpgItemService.getItemsByCategory(category);
    }

    @PostMapping("/items")
    public void createItem(@RequestBody RpgItemDTO rpgItem){
        rpgItemService.createItem(rpgItem.getName(),rpgItem.getCategory(),rpgItem.getPrice(),rpgItem.getEffect());
    }

    @PutMapping("/items/{id}")
    public void updateItem(@RequestBody RpgItemDTO rpgItem){
        Optional<RpgItem> item = rpgItemService.getItemById(rpgItem.getId());
        if(item.isPresent())
            rpgItemService.createItem(rpgItem.getName(),rpgItem.getCategory(),rpgItem.getPrice(),rpgItem.getEffect());
        else
            System.out.println("Item does not exist.");
    }
}

