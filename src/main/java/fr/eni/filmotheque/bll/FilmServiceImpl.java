package fr.eni.filmotheque.bll;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.dao.FilmDao;

@Service
public class FilmServiceImpl implements FilmService{
	
	FilmDao fd;
	public FilmServiceImpl(FilmDao fd) {
		this.fd=fd;
	}

	@Override
	public ArrayList<Film> selectAll() {
		return fd.selectAll();
	}

	@Override
	public Film selectOneById(int id) {
		return fd.selectOneById(id);
	}


	@Override
	public void insertFilm(Film film) {
		fd.insertFilm(film);
	}

}
