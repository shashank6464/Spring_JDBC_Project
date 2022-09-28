package com.springboot.jdbc.SpringBootJDBC.Controller;

import com.springboot.jdbc.SpringBootJDBC.Player;
import com.springboot.jdbc.SpringBootJDBC.Repository.PlayerDAO;
import com.springboot.jdbc.SpringBootJDBC.ServiceLayer.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerService service;
   // PlayerDAO obj = new PlayerDAO();

    @GetMapping("/players")
    public List<Player> getPlayerData(){
        return service.getAllPlayers();
    }

    @GetMapping("/welcome")
    public String Welcome(){ return "Welcome to Player Entity"; }

    @GetMapping("/player/{id}")
    public Player GetPlayer(@PathVariable int id){
        return service.findPlayerById(id);
    }



//    @GetMapping("playerById")
//    public Player getPlayerbyId(){
//        return obj.getPlayerbyId();
//    }

}