package fr.eni.filmotheque.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import fr.eni.filmotheque.bo.Film;

@Repository
public class FilmDaoImpl implements FilmDao {
	private ArrayList<Film> films = new ArrayList<>() ;
	
	public FilmDaoImpl(){
		films.add(new Film(1,"Cyrano de Bergerac", "1998", 160, "Il a un grand nez. Très GRAND."));
		films.add(new Film(2,"Cyrano de Bergerac", "1998", 160, "Il a un grand nez. Très GRAND."));
		films.add(new Film(3,"Cyrano de Bergerac", "1998", 160, "Il a un grand nez. Très GRAND."));
		films.add(new Film(4,"Cyrano de Bergerac", "1998", 160, "Il a un grand nez. Très GRAND."));
		films.add(new Film(5,"Cyrano de Bergerac", "1998", 160, "Il a un grand nez. Très GRAND."));
		films.add(new Film(6,"Cyrano de Bergerac", "1998", 160, "Il a un grand nez. Très GRAND."));
		films.add(new Film(7,"Cyrano de Bergerac", "1998", 160, "Il a un grand nez. Très GRAND."));
		films.add(new Film(8,"Cyrano de Bergerac", "1998", 160, "Il a un grand nez. Très GRAND."));
		films.add(new Film(9,"Cyrano de Bergerac", "1998", 160, "Il a un grand nez. Très GRAND."));
		films.add(new Film(10,"Cyrano de Bergerac", "1998", 172, "Il a un grand nez. Très GRAND."));
		films.add(new Film(11,"Cyrano de Bergerac", "1998", 160, "Il a un grand nez. Très GRAND."));
		films.add(new Film(12,"Cyrano de Bergerac", "1998", 160, "Il a un grand nez. Très GRAND."));
		films.add(new Film(13,"Cyrano de Bergerac", "1998", 160, "Il a un grand nez. Très GRAND."));
		films.add(new Film(14,"Transition 2023", "2023", 195, "Sylvain et Maïwenn vivent une histoire originale."));
	}

	@Override
	public ArrayList<Film> selectAll() {
		return films;
	}

	@Override
	public Film selectOneById(int id) {
		Film foundFilm = new Film();
		for (Film film : films) {
			if (id==film.getId()) {
				foundFilm = film;
			}
		}
		return foundFilm;
	}

	@Override
	public void insertFilm(Film film) {
		films.add(film);
	}
}
