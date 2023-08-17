package fr.eni.filmotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.filmotheque.bo.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>{
	
}
