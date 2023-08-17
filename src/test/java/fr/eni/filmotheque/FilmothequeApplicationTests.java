package fr.eni.filmotheque;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import fr.eni.filmotheque.bo.Author;
import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.service.FilmService;
import jakarta.transaction.Transactional;

@SpringBootTest
class FilmothequeApplicationTests {

	@Autowired
	@Qualifier("JPA")
	private FilmService fs;

	@Test
	void peuplerDb() {

		// ***************************** CYRANO DE BERGERAC *********************************************
		Genre g0 = new Genre();
		g0.setLabel("Drame");
		
		Author a0 = new Author("Depardieu", "Gérard");
		Author a1 = new Author("Rappeneau", "Jean-Paul");
		Author a2 = new Author("Brochet", "Anne");
		Author a3 = new Author("Perez", "Vincent");
		
		List<Author> actorsCyrano = List.of(a0,a2,a3);
		Film cyrano = new Film();
		cyrano.setTitle("Cyrano de Bergerac");
		cyrano.setReleaseYear("1990");
		cyrano.setDuration(135);
		cyrano.setSynopsis("Cyrano a un nez. Très grand. Il est pas content, il tue des gens, c'est la guerre à la fin. Encore plus à la fin, il meurt. Il meurt, mais avec PANACHE.");
		cyrano.setGenre(g0);
		cyrano.setDirector(a1);
		cyrano.setActors(actorsCyrano);
		System.err.println(cyrano);	
		
		fs.insertFilm(cyrano);
		
		// ***************************** BOWLING *********************************************
		
		Genre g1 = new Genre();
		g1.setLabel("Comédie dramatique");
		
		Author a7 = new Author("Frot", "Catherine");
		Author a10 = new Author("Richard", "Firmine");
		Author a11 = new Author("Mention-Schaar","Marie-Castille ");
		
		List<Author> actorsBowling = List.of(a7,a10);
		Film bowling = new Film();
		bowling.setTitle("Bowling");
		bowling.setReleaseYear("2012");
		bowling.setDuration(89);
		bowling.setSynopsis("Une équipe féminine se prépare à participer au championnat de Bretagne de bowling. Elle va devoir mener en parallèle un autre combat, celui pour conserver la maternité de Carhaix. ");
		bowling.setGenre(g1);
		bowling.setDirector(a11);
		bowling.setActors(actorsBowling);
		
		fs.insertFilm(bowling);
		
		// ***************************** AJOUT DES GENRES ET AUTEURS *********************************************
		
		Genre g2 = new Genre();
		g2.setLabel("Historique");
		Genre g3 = new Genre();
		g3.setLabel("SF");
		Genre g4 = new Genre();
		g4.setLabel("Fantasy");
		Genre g5 = new Genre();
		g5.setLabel("Western");
		Genre g6 = new Genre();
		g6.setLabel("Policier");
		Genre g7 = new Genre();
		g7.setLabel("Comédie");
		
		fs.insertGenre(g2);
		fs.insertGenre(g3);
		fs.insertGenre(g4);
		fs.insertGenre(g5);
		fs.insertGenre(g6);
		fs.insertGenre(g7);

		Author a4 = new Author("Deneuve", "Catherine");
		Author a5 = new Author("Luchini", "Fabrice");
		Author a6 = new Author("Casadesus", "Gisèle");
		Author a8 = new Author("Wilson", "Lambert");
		Author a9 = new Author("Ormesson", "Jean d'");
		Author a12 = new Author("Vincent","Christian" );
		
		fs.insertAuthor(a4);
		fs.insertAuthor(a5);
		fs.insertAuthor(a6);
		fs.insertAuthor(a8);
		fs.insertAuthor(a9);
		fs.insertAuthor(a12);
		
	}
	

//	@Test
//	@Transactional
//	@Rollback(false)
//	void ajoutFilmAvecSelectionDansLaBdd() {
//		
//		List<Author> actorsSaveursPalais = List.of(fs.getAuthorById(5));
//		System.err.println(fs.getAuthorById(5));
//		Film saveursDuPalais = new Film();
//		saveursDuPalais.setTitle("Les Saveurs du Palais");
//		saveursDuPalais.setReleaseYear("2012");
//		saveursDuPalais.setDuration(95);
//		saveursDuPalais.setSynopsis("Hortense Laborie est une cuisinière réputée qui vit dans le Périgord. À sa grande surprise, le président de la République la nomme responsable de ses repas personnels au palais de l'Élysée. Malgré les jalousies des chefs de la cuisine centrale, Hortense s'impose avec son caractère bien trempé. L’authenticité de sa cuisine séduit rapidement le président mais, dans les coulisses du pouvoir, les obstacles sont nombreux.Les séquences à l'Elysée alternent avec celles en Antarctique, sur la base Alfred-Faure des îles Crozet, où Hortense dispense sa cuisine aux membres de la base. ");
//		saveursDuPalais.setGenre(fs.getGenreById(7));
//		System.err.println(fs.getGenreById(7));
//		saveursDuPalais.setDirector(fs.getAuthorById(12));
//		System.err.println(fs.getAuthorById(12));
//		saveursDuPalais.setActors(actorsSaveursPalais);
//		
//		fs.insertFilm(saveursDuPalais);
//	}
	
	@Test
	void contextLoads() {
	}

}
