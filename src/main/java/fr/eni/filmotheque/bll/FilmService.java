package fr.eni.filmotheque.bll;

import java.util.ArrayList;

import fr.eni.filmotheque.bo.Film;

public interface FilmService {

	public ArrayList<Film> selectAll();
	public Film selectOneById(int id);
	public void insertFilm(Film film);
	
}
