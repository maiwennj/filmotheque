package fr.eni.filmotheque.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.filmotheque.bo.Author;
import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.service.FilmService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
public class FilmothequeController {
	
	@Autowired
	/**
	 * Création d'une variable de FilmService par INJECTION DE DÉPENDANCES
	 * Grâce à l'implémentation de FilmService dans FilmServiceImpl ET de l'annotation
	 * @Service sur ce dernier, il crée une instance.
	 * @Service crée un @Component, ce qui est un @Bean, donc un singleton
	 */
	private FilmService fs;
	@Autowired
	private EntityManager em;
	
	
	
	@GetMapping({"/","/home"})
	public String home(Model modele) {	//Model sert à transmettre des informations vers les templates html
		List<Film> films = fs.selectAll();
		modele.addAttribute("films",films);
		return "home";
	}
	
	@GetMapping("/film/detail/{filmId}")
	public String displayFilmDetail(@PathVariable String filmId,Model modele) {
		modele.addAttribute("film",fs.selectOneById(Integer.parseInt(filmId)));
		System.err.println(fs.selectOneById(Integer.parseInt(filmId)));
		return "filmDetail";
	}
	
	@GetMapping("/film/ajouter")
	public String displayAddMovie(Model model) {
		model.addAttribute("film", new Film());
		model.addAttribute("actors",fs.getAuthors());
		return "addMovie";
	}
	
	@PostMapping("/film/ajouter")
	public String addMovie(
			@Valid @ModelAttribute("film") Film film,
			BindingResult validationResult) {
		if(validationResult.hasErrors()) {
			return "addMovie";
		}
		
		this.fs.insertFilm(film);
		return "redirect:/home";
	}
	
	
	
}
