package fr.eni.filmotheque.service;

import java.util.List;

import fr.eni.filmotheque.bo.Author;
import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;

public interface FilmService {

	List<Film> selectAll();
	Film selectOneById(int id);
	List<Genre> getGenres();
	List<Author> getAuthors();
	Genre getGenreById(int id);
	Author getAuthorById(int id);
	void insertFilm(Film film);
	
}
