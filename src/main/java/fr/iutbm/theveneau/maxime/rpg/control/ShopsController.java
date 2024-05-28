package fr.iutbm.theveneau.maxime.rpg.control;

import fr.iutbm.theveneau.maxime.rpg.model.DTO.ShopDTO;
import fr.iutbm.theveneau.maxime.rpg.service.ShopsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rpg")
public class ShopsController {
    private final ShopsService shopsService;

    public ShopsController(ShopsService shopsService) {
        this.shopsService = shopsService;
    }

    @GetMapping("/shops")
    public List<ShopDTO> getAllShops() {
        return shopsService.getAllShops();
    }

    @GetMapping("/shops/{id}")
    public Optional<ShopDTO> getShopById(@PathVariable Long id){
        return shopsService.getShopById(id);
    }

    @GetMapping("/shops/byname/{name}")
    public Optional<ShopDTO> getShopByName(@PathVariable String name){
        return shopsService.getShopByName(name);
    }
}
