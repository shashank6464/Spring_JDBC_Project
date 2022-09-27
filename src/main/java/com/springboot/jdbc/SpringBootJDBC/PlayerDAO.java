package com.springboot.jdbc.SpringBootJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //READING TABLE DATA -ROWS
    public List<Player> getAllPlayers(){
        String getPlayerQuery = "SELECT * FROM Player";

        // JDBC TEMPLATE => Query =>Database => Result Set => Row Mapped => Player.Class => List<Object>
       // return jdbcTemplate.query(getPlayerQuery, new BeanPropertyRowMapper<Player>(Player.class));
        return jdbcTemplate.query(getPlayerQuery,new PlayerMapper());
    }

    public Player getPlayerbyId(int id){
        String getPlayerbyIdQuery = "SELECT * FROM Player WHERE ID = ?";

        // JDBC TEMPLATE => Query =>Id is substituted as Primary Key => Result Set => Row Mapped => Player.Class => List<Object>
        return jdbcTemplate.queryForObject(getPlayerbyIdQuery,new BeanPropertyRowMapper<Player>(Player.class), new Object[] {id});

    }
    //INSERTING a new ROW
    // Will return 1 after success
    public int insertPlayer(Player player){
        String insertPlayerQuery = "INSERT INTO Player VALUES(?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(insertPlayerQuery, new Object[]{player.getID(), player.getName(),player.getAge(),
                player.getNationality(), new Timestamp(player.getDob().getTime()), player.getDesignation()});
    }

    //UPDATE a certain ROW (by ID)
    public int updatePlayerInfo(Player player){
        String updateQuery = "UPDATE Player "+ " SET Name = ?, Age =?, Nationality=?,DOB=?, Designation=?"+
                "WHERE ID=?";
        return jdbcTemplate.update(updateQuery, new Object[]{player.getName(),player.getAge(),
                player.getNationality(), new Timestamp(player.getDob().getTime()), player.getDesignation(), player.getID()});
    }

    //Delete a ROW (by ID)
    public int deletePlayer(int id){
        String deleteQuery = "DELETE FROM Player "+" WHERE ID = ?";

        return jdbcTemplate.update(deleteQuery, new Object[]{id});
    }


    private static final class PlayerMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player player = new Player();

            player.setID(rs.getInt("ID"));
            player.setName(rs.getString("Name"));
            player.setAge(rs.getInt("Age"));
            player.setNationality(rs.getString("Nationality"));
            player.setDob(rs.getDate("DOB"));
            player.setDesignation(rs.getInt("Designation"));

            return player;

        }
    }

}