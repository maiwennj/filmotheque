package fr.eni.filmotheque.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.filmotheque.bo.Author;
import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;

@Service
public class FilmServiceMock implements FilmService{
	
	List<Film> listFilms = new ArrayList<Film>();
	List<Genre> listGenres = new ArrayList<Genre>();
	List<Author> listAuthors = new ArrayList<Author>();
	
	@Override
	public List<Film> selectAll() {
		return listFilms;
	}

	@Override
	public Film selectOneById(int id) {
		for (Film film : listFilms) {
			if(film.getId()==id) {
				return film;
			}
		}
		return null;
	}

	@Override
	public List<Genre> getGenres() {
		return listGenres;
	}

	@Override
	public List<Author> getAuthors() {
		return listAuthors;
	}

	@Override
	public Genre getGenreById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author getAuthorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertFilm(Film film) {
		listFilms.add(film);
	}

	@Override
	public void insertGenre(Genre genre) {
		listGenres.add(genre);
	}

	@Override
	public void insertAuthor(Author author) {
		listAuthors.add(author);
	}

}
