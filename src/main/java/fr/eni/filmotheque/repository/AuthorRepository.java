package fr.eni.filmotheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.filmotheque.bo.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
}
