package edu.csumb.cst438.herodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import edu.csumb.cst438.herodb.entities.Hero;

@Repository
public interface IHeroRepository extends MongoRepository<Hero, String> {
    @Query (value = "{'id':?0}")   
    Hero findByRepoId(String id);

    @Query (value = "{'powers.powers':?0}")
    List<Hero> findByPower(String power);

}