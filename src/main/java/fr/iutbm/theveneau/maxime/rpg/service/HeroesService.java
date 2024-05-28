package fr.iutbm.theveneau.maxime.rpg.service;

import fr.iutbm.theveneau.maxime.rpg.control.exceptions.HeroNotFoundException;
import fr.iutbm.theveneau.maxime.rpg.control.exceptions.ResourceNotFoundException;
import fr.iutbm.theveneau.maxime.rpg.model.Hero;
import fr.iutbm.theveneau.maxime.rpg.repository.HeroesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroesService {
    private HeroesRepository heroesRepository;

    @Autowired
    public HeroesService(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

    public List<Hero> findAll() {
        return heroesRepository.findAll();
    }

    public Page<Hero> findAllWithPagination(Pageable pageable) {
        return heroesRepository.findAll(pageable);
    }

    public Hero findHeroById(Long id) throws ResourceNotFoundException {
        System.out.println("Getting hero by id: " + id);
        Optional<Hero> hero = heroesRepository.findById(id);
        if (hero.isEmpty()) throw new HeroNotFoundException("searching for hero with id = "+id);
        return hero.get();
    }

    public Hero findHeroByPublicName(String publicName) throws ResourceNotFoundException {
        System.out.println("Getting hero by public name: " + publicName);
        Optional<Hero> hero = heroesRepository.findByPublicName(publicName);
        if (hero.isEmpty()) throw new ResourceNotFoundException("searching for hero with publicName = "+publicName);
        return hero.get();
    }

    public List<Hero> findAllByPower(String string, boolean pattern) {
        List<Hero> list = null;
        if (pattern) {
            System.out.println("Getting heroes with power containing " + string);
            list = heroesRepository.findAllByPowerContaining(string);
        }
        else {
            System.out.println("Getting heroes with power = " + string);
            list = heroesRepository.findAllByPower(string);
        }
        return list;
    }

    public long count() {
        long count = heroesRepository.count();
        return count;
    }

    public Hero createHero(String publicName, String realName, String power, Integer powerLevel) {
        Hero hero = new Hero(publicName, realName, power, powerLevel);
        heroesRepository.save(hero);

        return hero;
    }

    public Hero updateHero(Long id, String publicName, String realName, String power, Integer powerLevel) throws ResourceNotFoundException {
        Optional<Hero> heroOpt = heroesRepository.findById(id);
        if (heroOpt.isEmpty()) throw new HeroNotFoundException("updating hero with id = "+id);

        Hero hero = heroOpt.get();
        if (publicName != null) hero.setPublicName(publicName);
        if (realName != null) hero.setRealName(realName);
        if (power != null) hero.setPower(power);
        if (powerLevel != null) hero.setPowerLevel(powerLevel);
        heroesRepository.save(hero);
        return hero;
    }

    public void deleteHero(Long id) {
        Optional<Hero> heroOpt = heroesRepository.findById(id);
        if (heroOpt.isEmpty()) throw new HeroNotFoundException("deleting hero with id = "+id);
        heroesRepository.deleteById(id);
    }
}
