package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Player;
import dmacc.beans.Team;

@Configuration
public class BeanConfiguration {

	@Bean
	public Player player() {
		Player bean = new Player("Lebron James");
//		bean.setName("Lebron James");
//		bean.setHeight("6 ft. 9 in.");
//		bean.setPosition("Small Forward");
//		bean.setNumber(6);
//		bean.setYearsPro(19);
		return bean;
	}
	
	@Bean
	public Team team() {
		Team bean = new Team("Lakers", "Los Angeles", "California", "Crypto.com");
		return bean;
	}
}
