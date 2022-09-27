package com.springboot.jdbc.SpringBootJDBC;

import com.springboot.jdbc.SpringBootJDBC.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;


@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

//	@Autowired
//	PlayerDAO dao;

	@Autowired
	PlayerRepository repo;




	@Override
	public void run(String... args) throws Exception {
//		System.out.println("---------GET Players INFO ----------");
//		System.out.println(dao.getAllPlayers());
//		System.out.println("----------GET PLAYER BY ID ----------");
//		System.out.println(dao.getPlayerbyId(2));
//		System.out.println("--------INSERT A PLAYER -------------");
//		System.out.println(dao.insertPlayer(new Player(4,"Raju",35,"USA", new Date(System.currentTimeMillis()), 5)));
//
//		System.out.println("---------UPDATE A PLAYER INFO---------");
//		System.out.println(dao.updatePlayerInfo(new Player(4,"Raju",40,"UK", new Date(System.currentTimeMillis()), 5)));
//		System.out.println("--------DELETING A PLAYER-----------");
//		System.out.println(dao.deletePlayer(4));
//		System.out.println(dao.getAllPlayers());

		// -------------CRUD without DATABASE QUERY ---------

		//CREATE
		repo.insertPlayer(new Player("Raju",35,"USA", Date.valueOf("2000-04-10"), 1));
		repo.insertPlayer(new Player("Alice",30,"IND", Date.valueOf("2000-06-16"), 2));

		//READ
		System.out.println(repo.getPlayerById(2));

		//UPDATE
		repo.updatePlayer(new Player(2,"Alice",30,"UK", Date.valueOf("2000-06-16"), 2));

		//DELETE
		repo.deleteById(2);



		//	repo.updatePlayer(new Player(1,"Raju",35,"UK", Date.valueOf("2000-04-10"), 1));


	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);


	}



}