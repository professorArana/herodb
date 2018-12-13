package mil.osd.dmdc.herodb;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import mil.osd.dmdc.herodb.entities.AlterEgo;
import mil.osd.dmdc.herodb.entities.Hero;
import mil.osd.dmdc.herodb.entities.Identity;
import mil.osd.dmdc.herodb.entities.Powers;

@Component
public class HeroDbSeeder implements CommandLineRunner{
    @Autowired
    IHeroRepository heroRepo;

    @Override
    public void run(String... args) throws Exception {
        Hero ironMan = new Hero(new Identity("Tony Stark"), new AlterEgo("Iron Man"), new Powers(Arrays.asList("energy beams","flight")));
        Hero hulk = new Hero(new Identity("Bruce Banner"), new AlterEgo("The Hulk"), new Powers(Arrays.asList("super strength")));
        Hero spiderMan = new Hero(new Identity("Peter Parker"), new AlterEgo("Spider Man"), new Powers(Arrays.asList("super strength","webs","danger sense")));
        //delete db data
        heroRepo.deleteAll();
        //add db seeds
        List<Hero> heroes = Arrays.asList(ironMan, hulk, spiderMan);
        heroRepo.saveAll(heroes);
    }

}