package fr.eni.filmotheque.bll;

import java.util.ArrayList;

import fr.eni.filmotheque.bo.Author;

public interface AuthorService {
	
	public ArrayList<Author> selectAll();
	public Author selectById(int id);
	public void insertAuthor(Author author);
	public void updateAuthor(Author author);
	public void deleteAuthor(Author author);
	
}
