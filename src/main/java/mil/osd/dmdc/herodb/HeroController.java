package mil.osd.dmdc.herodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import mil.osd.dmdc.herodb.entities.Hero;

@RestController
public class HeroController {
    @Autowired
    IHeroRepository heroRepository;

    @GetMapping ("/allHeroes")
    public List<Hero> getAll () {
        List<Hero> result = heroRepository.findAll();
        return result;
    }
    	
    @GetMapping("/id/{id}")
    public Hero getHeroById (@PathVariable String id) {
        Hero result = heroRepository.findByRepoId(id);
        return result;
    }

    @GetMapping("/power/{power}")
    public List<Hero> getByPower (@PathVariable String power) {
        List<Hero> result = heroRepository.findByPower(power);
        return result;
    }
	
}