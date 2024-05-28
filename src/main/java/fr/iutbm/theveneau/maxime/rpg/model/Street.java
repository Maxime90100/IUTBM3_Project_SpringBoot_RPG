package fr.iutbm.theveneau.maxime.rpg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "streets")
public class Street {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "street")
    private List<Shop> shops;

    public Street(String name) {this.name = name;}

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
