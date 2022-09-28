package com.springboot.jdbc.SpringBootJDBC.Controller;

import com.springboot.jdbc.SpringBootJDBC.Player;
import com.springboot.jdbc.SpringBootJDBC.Repository.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerDAO obj = new PlayerDAO();

    @GetMapping("/players")
    public List<Player> getPlayerData(){
        return obj.getAllPlayers();
    }

//    @GetMapping("playerById")
//    public Player getPlayerbyId(){
//        return obj.getPlayerbyId();
//    }

}