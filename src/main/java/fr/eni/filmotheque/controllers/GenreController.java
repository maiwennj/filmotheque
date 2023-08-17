package fr.eni.filmotheque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.filmotheque.bo.Author;
import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.service.FilmService;
import jakarta.validation.Valid;


@Controller
public class GenreController {
	
	@Autowired
	@Qualifier("JPA")
	private FilmService fs;
	
	@GetMapping("/genres/ajouter")
	public String displayForm(Model model) {
		model.addAttribute("genre",new Genre());
		return "genres/addGenre";
	}
	
	@PostMapping("/genres/ajouter")
	public String traiterForm(@Valid @ModelAttribute Genre genre,BindingResult br) {
		if(br.hasErrors()) {
			return "genres/addGenre";
		}
		fs.insertGenre(genre);
		return "redirect:/films/ajouter";
	}

}
