package fr.iutbm.theveneau.maxime.rpg.repository;

import fr.iutbm.theveneau.maxime.rpg.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HeroesRepository extends JpaRepository<Hero, Long> {

    Optional<Hero> findByPublicName(String publicName);
    List<Hero> findAllByPower(String power);
    List<Hero> findAllByPowerContaining(String pattern);
}
