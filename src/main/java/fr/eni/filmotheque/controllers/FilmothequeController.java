package fr.eni.filmotheque.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.service.FilmService;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;

@Controller
public class FilmothequeController {
	
	
	/**
	 * Création d'une variable de FilmService par INJECTION DE DÉPENDANCES
	 * Grâce à l'implémentation de FilmService dans FilmServiceImpl ET de l'annotation
	 * @Service sur ce dernier, il crée une instance.
	 * @Service crée un @Component, ce qui est un @Bean, donc un singleton
	 */
	@Autowired
	@Qualifier("JPA")
	private FilmService fs;
	
	@GetMapping({"/","/home"})
	public String home(Model modele) {	//Model sert à transmettre des informations vers les templates html
		List<Film> films = fs.selectAll();
		modele.addAttribute("films",films);
		return "home";
	}
	
	@GetMapping("/films/detail/{filmId}")
	public String displayFilmDetail(@PathVariable String filmId,Model modele) {
		modele.addAttribute("film",fs.selectOneById(Integer.parseInt(filmId)));
		return "filmDetail";
	}
	
	@GetMapping("/films/ajouter")
	public String displayAddMovie(Model model) {
		model.addAttribute("film", new Film());
		model.addAttribute("actors",fs.getAuthors());
		model.addAttribute("genres",fs.getGenres());
		return "addMovie";
	}
	
	@PostMapping("/films/ajouter")
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
