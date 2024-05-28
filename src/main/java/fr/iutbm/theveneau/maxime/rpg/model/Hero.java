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
@Table(name = "heroes")
public class Hero {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="publicname", nullable = false, unique = true, length = 50)
    private String publicName;
    private String realName;
    private String power;
    private int powerLevel;

    public Hero(String publicName, String realName, String power, int powerLevel) {
        this.publicName = publicName;
        this.realName = realName;
        this.power = power;
        this.powerLevel = powerLevel;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", publicName='" + publicName + '\'' +
                ", realName='" + realName + '\'' +
                ", power='" + power + '\'' +
                ", powerLevel=" + powerLevel +
                '}';
    }
}
