package com.springboot.jdbc.SpringBootJDBC.ServiceLayer;


import com.springboot.jdbc.SpringBootJDBC.Player;
import com.springboot.jdbc.SpringBootJDBC.Repository.PlayerRepository;
import com.springboot.jdbc.SpringBootJDBC.Repository.PlayerSpringDataRepository;
import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerSpringDataRepository repo;

    //get all Players
    public List<Player> getAllPlayers(){
        return repo.findAll();

    }


    //http//localhost:8080/
    //find by Player ID
    public Player findPlayerById(@PathVariable("id") int id){
        Optional<Player> tempPlayer = repo.findById(id);
       // repo.getOne(id);

        Player p =null;

        if(tempPlayer.isPresent()) p = tempPlayer.get();
        else{
            throw new RuntimeException("Player with id:"+id+"not found");
        }
        return p;

    }

    //Add Player
    public Player addPlayer(Player player){
        return repo.save(player);
    }

    //update Player (PUT)
    public Player updatePlayerById(@PathVariable("id") int id,Player player){
        Optional<Player> tempPlayer = repo.findById(id);
        // repo.getOne(id);


        if(tempPlayer.isEmpty()) throw new RuntimeException("Player with id:"+id+"not found");

        return repo.save(player);

    }

    //update Player (patch)
    public Player patchPlayerById(@PathVariable("id") int id, Map<String, Object> partialPlayer){
        Optional<Player> tempPlayer = repo.findById(id);// just to capture null pointer exception if present

        if(tempPlayer.isPresent()){
            // iterate through map and make desired changes in player object
            partialPlayer.forEach( (key, value) -> {
                System.out.println("key : "+key+" , value : "+value);
                // findField-> finds the field of an object (class, key (attribute)) => returns field object
                Field field = ReflectionUtils.findField(Player.class, key);
                ReflectionUtils.makeAccessible(field); // make the private variables in use (toggles)
                ReflectionUtils.setField(field, tempPlayer.get(), value); // set the field with the updated/ patched data
            });
        }
        else{
            throw new RuntimeException("Player with id : "+id+" not found ");
        }
        return repo.save(tempPlayer.get());
    }


}
