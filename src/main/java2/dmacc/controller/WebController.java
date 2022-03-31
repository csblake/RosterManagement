package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Player;
import dmacc.repository.PlayerRepository;

@Controller
public class WebController {
	@Autowired
	PlayerRepository repo;
	
	@GetMapping({"/", "viewAll"})
	public String viewAllPlayers(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewPlayer(model);
		}
		
		model.addAttribute("players", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputPlayer")
	public String addNewPlayer(Model model) {
		Player p = new Player();
		model.addAttribute("newPlayer", p);
		return "input";
	}
	
	@PostMapping("/inputPlayer")
	public String addNewPlayer(@ModelAttribute Player p, Model model) {
		repo.save(p);
		return viewAllPlayers(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdatePlayer(@PathVariable("id") long id, Model model) {
		Player p = repo.findById(id).orElse(null);
		model.addAttribute("newPlayer", p);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String revisePlayer(Player p, Model model) {
		repo.save(p);
		return viewAllPlayers(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deletePlayer(@PathVariable("id") long id, Model model) {
		Player p = repo.findById(id).orElse(null);
		repo.delete(p);
		return viewAllPlayers(model); 
	}
}
