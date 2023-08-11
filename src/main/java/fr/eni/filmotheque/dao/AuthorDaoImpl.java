package fr.eni.filmotheque.dao;

import java.util.ArrayList;

import fr.eni.filmotheque.bo.Author;

public class AuthorDaoImpl implements AuthorDao{
	
	private ArrayList<Author> authors = new ArrayList<>();
	
	public AuthorDaoImpl () {
		authors.add(new Author(0,"Depardieu","Gérard"));
		authors.add(new Author(1,"Rappeneau","Jean-Paul"));
		authors.add(new Author(2,"Brochet","Anne"));
		authors.add(new Author(3,"Perez","Vincent"));
		authors.add(new Author(4,"Deneuve","Catherine"));
		authors.add(new Author(5,"Luchini","Fabrice"));
		authors.add(new Author(6,"Casadesus","Gisèle"));
		authors.add(new Author(7,"Frot","Catherine"));
		authors.add(new Author(8,"Wilson","Lambert"));
		authors.add(new Author(9,"Ormesson","Jean d'"));
		authors.add(new Author(10,"Richard","Firmine"));
	}

	@Override
	public ArrayList<Author> selectAll() {
		return null;
	}

	@Override
	public Author selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAuthor(Author author) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAuthor(Author author) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAuthor(Author author) {
		// TODO Auto-generated method stub
		
	}

}
