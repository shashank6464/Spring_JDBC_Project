package com.springboot.jdbc.SpringBootJDBC.Repository;

import com.springboot.jdbc.SpringBootJDBC.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer> {

   // public List<Player> findByNationality(String Nationality);

}
