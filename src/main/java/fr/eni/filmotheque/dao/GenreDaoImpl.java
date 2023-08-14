package fr.eni.filmotheque.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import fr.eni.filmotheque.bo.Genre;

@Repository
public class GenreDaoImpl implements GenreDao{
	
	private ArrayList<Genre> genres = new ArrayList<>();
	
	public GenreDaoImpl() {
		genres.add(new Genre(0,"Drame"));
		genres.add(new Genre(1,"Comédie"));
		genres.add(new Genre(2,"Historique"));
		genres.add(new Genre(3,"SF"));
		genres.add(new Genre(4,"Fantasy"));
		genres.add(new Genre(5,"Western"));
		genres.add(new Genre(6,"Policier"));
	}

	@Override
	public ArrayList<Genre> selectAll() {
		return genres;
	}

	@Override
	public Genre selectOneById(int id) {
		return genres.get(id);
	}

	@Override
	public void insertGenre(Genre genre) {
		genres.add(genre);
	}

	@Override
	public void updateGenre(Genre genre) {
		genres.set(genre.getId(), genre);
	}

	@Override
	public void deleteGenre(Genre genre) {
		genres.remove(genre);
	}

}
