package fr.eni.filmotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.filmotheque.bo.Author;
import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.repository.AuthorRepository;
import fr.eni.filmotheque.repository.FilmRepository;
import fr.eni.filmotheque.repository.GenreRepository;


@Service ("JPA")
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository fr;
	@Autowired
	private GenreRepository gr;
	@Autowired
	private AuthorRepository ar;
	
	@Override
	public List<Film> selectAll() {
		return fr.findAll();
	}

	@Override
	public List<Genre> getGenres() {
		return gr.findAll();
	}

	@Override
	public List<Author> getAuthors() {
		return ar.findAll();
	}

	@Override
	public Film selectOneById(Integer id) {
		return fr.findById(id).get();
	}

	@Override
	public Genre getGenreById(Integer id) {
		return gr.findById(id).get();
	}

	@Override
	public Author getAuthorById(Integer id) {
		return ar.findById(id).get();
	}

	@Override
	public void insertFilm(Film film) {
		System.out.println("bonjour Adel");
		fr.save(film);
	}

	@Override
	public void insertGenre(Genre genre) {
		gr.save(genre);
	}

	@Override
	public void insertAuthor(Author author) {
		
		ar.save(author);
	}

}
