package edu.csumb.cst438.herodb;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.csumb.cst438.herodb.entities.Hero;

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

    @GetMapping("/someData")
    public String getThirdPartyData (){
        RestTemplate myTemplate = new RestTemplate();
        String resourceUrl = "https://reqres.in/api/users";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);


        ResponseEntity<String> response = myTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        return response.getBody();
        //return "hello"; 
    }
	
}