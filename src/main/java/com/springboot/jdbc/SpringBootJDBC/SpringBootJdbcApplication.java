package com.springboot.jdbc.SpringBootJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;


@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

	@Autowired
	PlayerDAO dao;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("---------GET Players INFO ----------");
		System.out.println(dao.getAllPlayers());
		System.out.println("----------GET PLAYER BY ID ----------");
		System.out.println(dao.getPlayerbyId(2));
		System.out.println("--------INSERT A PLAYER -------------");
		System.out.println(dao.insertPlayer(new Player(4,"Raju",35,"USA", new Date(System.currentTimeMillis()), 5)));

		System.out.println("---------UPDATE A PLAYER INFO---------");
		System.out.println(dao.updatePlayerInfo(new Player(4,"Raju",40,"UK", new Date(System.currentTimeMillis()), 5)));
		System.out.println("--------DELETING A PLAYER-----------");
		System.out.println(dao.deletePlayer(4));
		System.out.println(dao.getAllPlayers());


	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);


	}



}