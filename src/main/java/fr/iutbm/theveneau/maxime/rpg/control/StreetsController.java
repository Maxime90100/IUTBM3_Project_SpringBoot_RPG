package fr.iutbm.theveneau.maxime.rpg.control;

import fr.iutbm.theveneau.maxime.rpg.model.DTO.StreetDTO;
import fr.iutbm.theveneau.maxime.rpg.service.StreetsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rpg")
public class StreetsController {
    private final StreetsService streetsService;

    public StreetsController(StreetsService streetsService) {
        this.streetsService = streetsService;
    }

    @GetMapping("/streets")
    public List<StreetDTO> getAllStreets() {
        return streetsService.getAllStreets();
    }

    @GetMapping("/streets/{id}")
    public Optional<StreetDTO> getStreetById(@PathVariable Long id){
        return streetsService.getStreetById(id);
    }

    @GetMapping("/streets/byname/{name}")
    public Optional<StreetDTO> getStreetByName(@PathVariable String name){
        return streetsService.getStreetByName(name);
    }
}
