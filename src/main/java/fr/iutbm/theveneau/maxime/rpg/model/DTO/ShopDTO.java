package fr.iutbm.theveneau.maxime.rpg.model.DTO;

import fr.iutbm.theveneau.maxime.rpg.model.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {

    private Long id;
    private String name;

    public static ShopDTO fromEntity(Shop shop) {
        if (shop == null) {
            return null;
        }
        return new ShopDTO(shop.getId(), shop.getName());
    }

    @Override
    public String toString() {
        return "ShopDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
