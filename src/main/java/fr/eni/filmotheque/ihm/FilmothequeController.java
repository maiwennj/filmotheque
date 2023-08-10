package fr.eni.filmotheque.ihm;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.eni.filmotheque.bll.FilmService;
import fr.eni.filmotheque.bo.Film;

@Controller
public class FilmothequeController {
	
	/**
	 * Création d'une variable de FilmService par INJECTION DE DÉPENDANCES
	 * Grâce à l'implémentation de FilmService dans FilmServiceImpl ET de l'annotation
	 * @Service sur ce dernier, il crée une instance.
	 * @Service crée un @Component, ce qui est un @Bean, donc un singleton
	 */
	private FilmService fs;
	
	/**
	 * Le constructeur du contrôleur, auquel on indique qu'on a besoin d'implémenter une instance de FilmService
	 */
	public FilmothequeController(FilmService fs) {
		this.fs = fs;
	}
	

	
	@GetMapping({"/","/home"})
	public String home(Model modele) {	//Model sert à transmettre des informations vers les templates html
		ArrayList<Film> films = fs.selectAll();
		modele.addAttribute("films",films);
		return "home";
	}
	
	@GetMapping("/film/detail/{filmId}")
	public String displayFilmDetail(@PathVariable String filmId,Model modele) {
		modele.addAttribute("film",fs.selectOneById(Integer.parseInt(filmId)));
		return "filmDetail";
	}
	
	@GetMapping("/film/ajouter")
	public String addMovie() {
		return "addMovie";
	}
	
	
	
}
