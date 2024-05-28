package fr.iutbm.theveneau.maxime.rpg.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RpgItemDTO {

    private Long id;
    private String name;
    private String category;
    private Double price;
    private String effect;

    @Override
    public String toString() {
        return "RpgItemDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", effect=" + effect +
                '}';
    }
}
