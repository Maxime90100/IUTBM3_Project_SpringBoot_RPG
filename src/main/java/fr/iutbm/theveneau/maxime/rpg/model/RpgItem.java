package fr.iutbm.theveneau.maxime.rpg.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "rpgitems")
public class RpgItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String effect;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ItemCategory category;

    public RpgItem(String name, ItemCategory category, Double price, String effect) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.effect = effect;
    }

    @Override
    public String toString() {
        return "RpgItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category.getName() + '\'' +
                ", price=" + price +
                ", effect='" + effect + '\'' +
                '}';
    }
}

