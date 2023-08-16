package fr.eni.filmotheque.service;

import java.util.List;

import fr.eni.filmotheque.bo.Author;
import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;

public interface FilmService {

	List<Film> selectAll();
	List<Genre> getGenres();
	List<Author> getAuthors();
	Film selectOneById(int id);
	Genre getGenreById(int id);
	Author getAuthorById(int id);
	void insertFilm(Film film);
	void insertGenre(Genre genre);
	void insertAuthor(Author author);
}
