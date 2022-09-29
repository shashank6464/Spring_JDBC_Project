package com.springboot.jdbc.SpringBootJDBC.Repository;

import com.springboot.jdbc.SpringBootJDBC.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer> {

    public List<Player> findByNationality(String Nationality);

    @Modifying
    @Query("UPDATE Player p SET p.nationality = :nationality WHERE p.id =:id")
    void updateNationality(@Param("id") int id, @Param("nationality") String nationality);


}
