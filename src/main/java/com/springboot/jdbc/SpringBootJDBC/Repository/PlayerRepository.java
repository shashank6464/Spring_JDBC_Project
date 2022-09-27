package com.springboot.jdbc.SpringBootJDBC.Repository;


import com.springboot.jdbc.SpringBootJDBC.Player;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

//JPA - java persistence api( JPA based repository)
@Repository
@Transactional  // to make transaction b/w java classes and database
public class PlayerRepository {

    @PersistenceContext
    EntityManager entityManager;


    // Insert
    public Player insertPlayer(Player player){

        return entityManager.merge(player);
    }

    // Update
    public Player updatePlayer(Player player){

        return entityManager.merge(player);
    }

    // Get/Read
    public Player getPlayerById(int id){
        return entityManager.find(Player.class, id);

    }

    // Delete
    public void deleteById(int id){
        Player player = entityManager.find(Player.class, id);
        entityManager.remove(player);

    }

}
