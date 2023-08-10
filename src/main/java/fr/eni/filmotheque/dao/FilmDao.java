package fr.eni.filmotheque.dao;

import java.util.ArrayList;

import fr.eni.filmotheque.bo.Film;

public interface FilmDao {

	public ArrayList<Film> selectAll();
	public Film selectOneById(int id);
	public void insertFilm(Film film);
}
