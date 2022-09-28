package com.springboot.jdbc.SpringBootJDBC;


import com.springboot.jdbc.SpringBootJDBC.Repository.PlayerSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class TennisPlayerSpringDataApplication implements CommandLineRunner
{
    @Autowired
    PlayerSpringDataRepository repo;
    private Logger logger = LoggerFactory.getLogger((this.getClass()));
    public static void main(String[] args)
    {
        SpringApplication.run(TennisPlayerSpringDataApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        logger.info("\n Inserting a player \n", repo.save(new Player("Mohit",20,"INDIA", Date.valueOf("2000-01-11"),1)));
        logger.info("\n Inserting a player \n", repo.save(new Player("Raj",30,"UK", Date.valueOf("1990-01-07"),2)));
        logger.info("\n Inserting a player \n", repo.save(new Player("Abhi",21,"USA", Date.valueOf("2001-08-09"),3)));
        //
        logger.info("\n Findin the player by ID \n", repo.findById(1));
//        logger.info("\n Delete By ID method \n");
//        repo.deleteById(1);
        logger.info("\n Find All players \n",repo.findAll());
    }
}
