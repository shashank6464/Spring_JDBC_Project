package com.springboot.jdbc.SpringBootJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Player> getAllPlayers(){
        String getPlayerQuery = "SELECT * FROM Player";

        // JDBC TEMPLATE => Query =>Database => Result Set => Row Mapped => Player.Class => List<Object>
        return jdbcTemplate.query(getPlayerQuery, new BeanPropertyRowMapper<Player>(Player.class));
    }

    public Player getPlayerbyId(int id){
        String getPlayerbyIdQuery = "SELECT * FROM Player WHERE ID = ?";

        // JDBC TEMPLATE => Query =>Id is substituted as Primary Key => Result Set => Row Mapped => Player.Class => List<Object>
        return jdbcTemplate.queryForObject(getPlayerbyIdQuery, new BeanPropertyRowMapper<Player>(Player.class), new Object[] {id});

    }

    public int insertPlayer(Player player){
        String insertPlayerQuery = "INSERT INTO Player VALUES(?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(insertPlayerQuery, new Object[]{player.getID(), player.getName(),player.getAge(),
                player.getNationality(), new Timestamp(player.getDob().getTime()), player.getDesignation()});
    }

}