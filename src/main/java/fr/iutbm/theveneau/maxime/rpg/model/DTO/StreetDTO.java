package fr.iutbm.theveneau.maxime.rpg.model.DTO;

import fr.iutbm.theveneau.maxime.rpg.model.Street;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StreetDTO {

    private Long id;
    private String name;
    private List<ShopDTO> shops;

    public static StreetDTO fromEntity(Street street) {
        if (street == null) {
            return null;
        }
        List<ShopDTO> shopDTOs = street.getShops().stream()
                .map(ShopDTO::fromEntity)
                .collect(Collectors.toList());
        return new StreetDTO(street.getId(), street.getName(), shopDTOs);
    }

    @Override
    public String toString() {
        return "StreetDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shops=" + shops +
                '}';
    }
}
