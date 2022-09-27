package com.springboot.jdbc.SpringBootJDBC.Repository;


import com.springboot.jdbc.SpringBootJDBC.Player;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

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

    //get all Players
    public List<Player> getAllPlayers(){
        TypedQuery<Player> getAll = entityManager.createNamedQuery("get_all_players", Player.class);

        return getAll.getResultList();

    }

}
