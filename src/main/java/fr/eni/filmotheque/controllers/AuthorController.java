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
import fr.eni.filmotheque.service.FilmService;
import jakarta.validation.Valid;


@Controller
public class AuthorController {
	
	@Autowired
	@Qualifier("JPA")
	private FilmService fs;
	
	@GetMapping("/auteurs/ajouter")
	public String displayForm(Model model) {
		model.addAttribute("author",new Author());
		return "authors/addAuthor";
	}
	
	@PostMapping("/auteurs/ajouter")
	public String traiterForm(@Valid @ModelAttribute Author author,BindingResult br) {
		if(br.hasErrors()) {
			return "authors/addAuthor";
		}
		fs.insertAuthor(author);
		return "redirect:/films/ajouter";
	}

}
