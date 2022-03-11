package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Player;
import dmacc.beans.Team;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.PlayerRepository;

@SpringBootApplication
public class RosterManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RosterManagementApplication.class, args);
	}

	@Autowired
	PlayerRepository repo;
	
	public void run(String...args) throws Exception {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		Player p = appContext.getBean("player", Player.class);
		repo.save(p);
		
		Player l = new Player("Lebron James", "6 ft. 9 in.", "Small Forward", 6, 19);
		l.setPosition("Small Forward");
		Team t = new Team("Lakers", "Los Angeles", "California", "Crypto.com");
		l.setTeam(t);
		repo.save(l);
		
		List<Player> allMyPlayers = repo.findAll();
		for(Player players: allMyPlayers) {
			System.out.println(players.toString());
		}
		
		((AbstractApplicationContext) appContext).close();
	}
}
