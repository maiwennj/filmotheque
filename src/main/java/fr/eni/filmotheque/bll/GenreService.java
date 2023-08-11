package fr.eni.filmotheque.bll;

import java.util.ArrayList;

import fr.eni.filmotheque.bo.Genre;

public interface GenreService {
	
	public ArrayList<Genre> selectAll();
	public Genre selectOneById(int id);
	public void insertGenre(Genre genre);
	public void updateGenre(Genre genre);
	public void deleteGenre(Genre genre);

}
