package fr.iutbm.theveneau.maxime.rpg.runner;

import fr.iutbm.theveneau.maxime.rpg.model.Hero;
import fr.iutbm.theveneau.maxime.rpg.repository.HeroesRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class initDB implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(initDB.class);

    private final HeroesRepository heroesRepository;

    @Autowired
    public initDB(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Hero phil = new Hero("maxou", "maxime theveneau", "*", 100);
        heroesRepository.save(phil);

        logger.info("getting all heroes");
        List<Hero> list = heroesRepository.findAll();
        for(Hero h : list) {
            System.out.println(h);
        }
    }
}
