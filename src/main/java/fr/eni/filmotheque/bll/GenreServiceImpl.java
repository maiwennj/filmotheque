package fr.eni.filmotheque.bll;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.dao.GenreDao;

@Service
public class GenreServiceImpl implements GenreService{
	
	GenreDao gd;
	public GenreServiceImpl (GenreDao gd) {
		this.gd=gd;
	}

	@Override
	public ArrayList<Genre> selectAll() {
		return gd.selectAll();
	}

	@Override
	public Genre selectOneById(int id) {
		return gd.selectOneById(id);
	}

	@Override
	public void insertGenre(Genre genre) {
		gd.insertGenre(genre);
	}

	@Override
	public void updateGenre(Genre genre) {
		gd.updateGenre(genre);
	}

	@Override
	public void deleteGenre(Genre genre) {
		gd.deleteGenre(genre);
	}
	
}
