package fr.iutbm.theveneau.maxime.rpg.repository;

import fr.iutbm.theveneau.maxime.rpg.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StreetsRepository extends JpaRepository<Street,Long> {
    Optional<Street> findByName(String name);
}
