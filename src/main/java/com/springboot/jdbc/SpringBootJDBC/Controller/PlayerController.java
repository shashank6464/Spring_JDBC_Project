package com.springboot.jdbc.SpringBootJDBC.Controller;

import com.springboot.jdbc.SpringBootJDBC.Player;
import com.springboot.jdbc.SpringBootJDBC.Repository.PlayerDAO;
import com.springboot.jdbc.SpringBootJDBC.ServiceLayer.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

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

    @PostMapping("addPlayer")
   // @RequestMapping(method=RequestMethod.POST)
    public Player addPlayer(@RequestBody Player p){
       // p.setName("Rex");
        return service.addPlayer(p);
    }

    @PutMapping("/updatePlayer/{id}")
    public Player updatePlayer(@PathVariable int id, @RequestBody Player p) {
        return service.updatePlayerById(id, p);

    }

    @PatchMapping("patchPlayer/{id}")
    public Player patchPlayer(@PathVariable int id, @RequestBody Map<String, Object> playerPatch){
        return service.patchPlayerById(id, playerPatch);
    }

    //updating with query (only for nationality)
    @PatchMapping("/patchPlayer/{id}/nationality")
    public void patchNationality(@PathVariable int id, @RequestBody String nationality){
        service.updateNationality(id, nationality);
    }

    //updating with query (for age and nationality)
    @PatchMapping("/patchPlayer/{id}/age/nationality")
    public void patchAgeNationality(@PathVariable int id, @RequestBody Map<String,Object> partialDetails){
        service.updateAgeAndNationality(id,Integer.parseInt(partialDetails.get("age").toString()),partialDetails.get("nationality").toString());
    }


    //deleting a palyer
    @DeleteMapping("/deletePlayer/{id}")
    public void deletePlayer(@PathVariable int id){
        service.deletePlayer(id);
    }






//    @GetMapping("playerById")
//    public Player getPlayerbyId(){
//        return obj.getPlayerbyId();
//    }

}