package fr.eni.filmotheque;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import fr.eni.filmotheque.bo.Author;
import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.service.FilmService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
class FilmothequeApplicationTests {
	
	@Autowired
	private FilmService fs;
	@Autowired
	private EntityManager em;
	
	// ajouter la dépendance pour l'entitymanager
	@Test
	@Transactional
	@Rollback(false)
	void test() {
		
		Genre g0 = new Genre();
		g0.setLabel("Drame");
		Genre g1 = new Genre();
		g1.setLabel("Comédie");
		Genre g2 = new Genre(2,"Historique");
		Genre g3 = new Genre(3,"SF");
		Genre g4 = new Genre(4,"Fantasy");
		Genre g5 = new Genre(5,"Western");
		Genre g6 = new Genre(6,"Policier");
	
		fs.insertGenre(g0);
		em.persist(g0);
		fs.insertGenre(g5);
		em.persist(g5);
		fs.insertGenre(g4);
		em.persist(g4);
		fs.insertGenre(g3);
		em.persist(g3);
		fs.insertGenre(g2);
		em.persist(g2);
		fs.insertGenre(g1);
		em.persist(g1);
		fs.insertGenre(g0);
		em.persist(g0);
		
		Author a0 = new Author(0,"Depardieu","Gérard");
		Author a1 = new Author(1,"Rappeneau","Jean-Paul");
		Author a2 = new Author(2,"Brochet","Anne");
		Author a3 = new Author(3,"Perez","Vincent");
		Author a4 = new Author(4,"Deneuve","Catherine");
		Author a5 = new Author(5,"Luchini","Fabrice");
		Author a6 = new Author(6,"Casadesus","Gisèle");
		Author a7 = new Author(7,"Frot","Catherine");
		Author a8 = new Author(8,"Wilson","Lambert");
		Author a9 = new Author(9,"Ormesson","Jean d'");
		Author a10 = new Author(10,"Richard","Firmine");
		
		fs.insertAuthor(a10);
		em.persist(a10);
		fs.insertAuthor(a9);
		em.persist(a9);
		fs.insertAuthor(a8);
		em.persist(a8);
		fs.insertAuthor(a7);
		em.persist(a7);
		fs.insertAuthor(a6);
		em.persist(a6);
		fs.insertAuthor(a5);
		em.persist(a5);
		fs.insertAuthor(a4);
		em.persist(a4);
		fs.insertAuthor(a3);
		em.persist(a3);
		fs.insertAuthor(a2);
		em.persist(a2);
		fs.insertAuthor(a1);
		em.persist(a1);
		fs.insertAuthor(a0);
		em.persist(a0);
		
		List<Author> actorsCyrano = List.of(a0,a2,a3);
		Film cyrano = new Film();
		cyrano.setTitle("Cyrano de Bergerac");
		cyrano.setReleaseYear("1998");
		cyrano.setDuration(160);
		cyrano.setSynopsis("Cyrano a un nez. Très grand. Il est pas content, il tue des gens, c'est la guerre à la fin. Encore plus à la fin, il meurt. Il meurt, mais avec PANACHE.");
		cyrano.setGenre(g0);
		cyrano.setDirector(a1);
		cyrano.setActors(actorsCyrano);
		
		List<Author> actorsSaveursPalais = List.of(a7,a9);
		Film saveursDuPalais = new Film();
		saveursDuPalais.setTitle("Les Saveurs du Palais");
		saveursDuPalais.setReleaseYear("2010");
		saveursDuPalais.setDuration(160);
		saveursDuPalais.setSynopsis("La dame cuisine pour le Président.");
		saveursDuPalais.setGenre(g1);
		saveursDuPalais.setDirector(a1);
		saveursDuPalais.setActors(actorsSaveursPalais);
		
		List<Author> actorsBowling = List.of(a7,a10);
		Film bowling = new Film();
		bowling.setTitle("Bowling");
		bowling.setReleaseYear("2010");
		bowling.setDuration(160);
		bowling.setSynopsis("La Parisienne finit par faire du bowling avec l'équipe de Carrhaix.");
		bowling.setGenre(g1);
		bowling.setDirector(a1);
		bowling.setActors(actorsBowling);
		
		fs.insertFilm(bowling);
		em.persist(bowling);
		fs.insertFilm(saveursDuPalais);
		em.persist(saveursDuPalais);
		fs.insertFilm(cyrano);
		em.persist(cyrano);
	}


	@Test
	void contextLoads() {
	}

}
