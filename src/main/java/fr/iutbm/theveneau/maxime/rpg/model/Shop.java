package fr.iutbm.theveneau.maxime.rpg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;

    public Shop(String name, Street street) {
        this.name = name;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
