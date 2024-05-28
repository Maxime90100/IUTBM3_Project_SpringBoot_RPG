package fr.iutbm.theveneau.maxime.rpg.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HeroDTO {

    private Long id;
    private String publicName;
    private String realName;
    private String power;
    private Integer powerLevel;

    @Override
    public String toString() {
        return "HeroDTO{" +
                "id=" + id +
                ", publicName='" + publicName + '\'' +
                ", realName='" + realName + '\'' +
                ", power='" + power + '\'' +
                ", powerLevel=" + powerLevel +
                '}';
    }
}
