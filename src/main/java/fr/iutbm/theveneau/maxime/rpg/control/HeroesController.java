package fr.iutbm.theveneau.maxime.rpg.control;

import fr.iutbm.theveneau.maxime.rpg.control.exceptions.ResourceNotFoundException;
import fr.iutbm.theveneau.maxime.rpg.model.DTO.HeroDTO;
import fr.iutbm.theveneau.maxime.rpg.model.Hero;
import fr.iutbm.theveneau.maxime.rpg.service.HeroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rpg")
public class HeroesController {

    private final HeroesService heroesService;

    @Autowired
    HeroesController(HeroesService heroesService) {
        this.heroesService = heroesService;
    }

    @GetMapping("/heroes")
    public List<Hero> getAllHeroes() {
        return heroesService.findAll();
    }
    @GetMapping("/heroes/{id}")
    public Hero getHeroById(@PathVariable Long id) throws ResourceNotFoundException {
        return heroesService.findHeroById(id);
    }
    @GetMapping("/heroes/paging")
    public Page<Hero> getAllHeroesWithPagination(
            @PageableDefault(page = 0, size = 5)
            @SortDefault.SortDefaults(
                    {@SortDefault(sort = "id", direction = Sort.Direction.ASC)}
            )Pageable pageable)
    {
        return heroesService.findAllWithPagination(pageable);
    }
    @GetMapping("/heroes/getbypublicname/{name}")
    public Hero getHeroByPublicName(@PathVariable String name) throws ResourceNotFoundException {
        return heroesService.findHeroByPublicName(name);
    }
    @GetMapping("/heroes/getbypower")
    public ResponseEntity<List<Hero>> getHeroesByPower(
            @RequestParam String power,
            @RequestParam(required = false) Boolean pattern)
    {
        List<Hero> list = null;
        if (pattern == null) pattern = false;
        list = heroesService.findAllByPower(power,pattern);

        if (list.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

        return ResponseEntity
                .ok()
                .header("myheader","toto")
                .header("otherheader","hello")
                .body(list);
    }
    @GetMapping("/heroes/count")
    public long getItemsCount() {
        return heroesService.count();
    }

    @PostMapping("/heroes")
    public Hero createHero(@RequestBody HeroDTO hero)  {
        return heroesService.createHero( hero.getPublicName(), hero.getRealName(), hero.getPower(), hero.getPowerLevel());
    }

    @PutMapping("/heroes")
    public Hero updateHero(@RequestBody HeroDTO hero) throws ResourceNotFoundException {
        return heroesService.updateHero(hero.getId(), hero.getPublicName(), hero.getRealName(), hero.getPower(), hero.getPowerLevel());
    }

    @DeleteMapping("/heroes/{id}")
    public void deleteHeroById(@PathVariable Long id) throws ResourceNotFoundException {
        heroesService.deleteHero(id);
    }
}
