package com.springboot.jdbc.SpringBootJDBC.ServiceLayer;


import com.springboot.jdbc.SpringBootJDBC.Player;
import com.springboot.jdbc.SpringBootJDBC.Repository.PlayerRepository;
import com.springboot.jdbc.SpringBootJDBC.Repository.PlayerSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
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



}
