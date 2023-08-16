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
	
	@PostConstruct
	public void init() {
		Genre g0 = new Genre(0,"Drame");
		Genre g1 = new Genre(1,"Comédie");
		Genre g2 = new Genre(2,"Historique");
		Genre g3 = new Genre(3,"SF");
		Genre g4 = new Genre(4,"Fantasy");
		Genre g5 = new Genre(5,"Western");
		Genre g6 = new Genre(6,"Policier");
		
		Author a0 = new Author(0,"Depardieu","Gérard");
		Author a1 = new Author(1,"Rappeneau","Jean-Paul");
		Author a2 = new Author(2,"Brochet","Anne");
		Author a3 = new Author(3,"Perez","Vincent");
		Author a4 = new Author(4,"Deneuve","Catherine");
		Author a5 = new Author(5,"Luchini","Fabrice");
		Author a6 = new Author(6,"Casadesus","Gisèle");
		Author a7 = new Author(7,"Frot","Catherine");
		Author a8 = new Author(8,"Wilson","Lambert");
		Author a9 = new Author(9,"Ormesson","Jean d'");
		Author a10 = new Author(10,"Richard","Firmine");
		
		List<Author> actorsCyrano = List.of(a0,a2,a3);
		Film cyrano = new Film();
		cyrano.setTitle("Cyrano de Bergerac");
		cyrano.setReleaseYear("1998");
		cyrano.setDuration(160);
		cyrano.setSynopsis("Cyrano a un nez. Très grand. Il est pas content, il tue des gens, c'est la guerre à la fin. Encore plus à la fin, il meurt. Il meurt, mais avec PANACHE.");
		cyrano.setGenre(g0);
		cyrano.setDirector(a1);
		cyrano.setActors(actorsCyrano);
		
		List<Author> actorsSaveursPalais = List.of(a7,a9);
		Film saveursDuPalais = new Film();
		saveursDuPalais.setTitle("Les Saveurs du Palais");
		saveursDuPalais.setReleaseYear("2010");
		saveursDuPalais.setDuration(160);
		saveursDuPalais.setSynopsis("La dame cuisine pour le Président.");
		saveursDuPalais.setGenre(g1);
		saveursDuPalais.setDirector(a1);
		saveursDuPalais.setActors(actorsSaveursPalais);
		
		List<Author> actorsBowling = List.of(a7,a10);
		Film bowling = new Film();
		bowling.setTitle("Bowling");
		bowling.setReleaseYear("2010");
		bowling.setDuration(160);
		bowling.setSynopsis("La Parisienne finit par faire du bowling avec l'équipe de Carrhaix.");
		bowling.setGenre(g1);
		bowling.setDirector(a1);
		bowling.setActors(actorsBowling);
		
		fs.insertFilm(bowling);
		fs.insertFilm(saveursDuPalais);
		fs.insertFilm(cyrano);
	}
	
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
