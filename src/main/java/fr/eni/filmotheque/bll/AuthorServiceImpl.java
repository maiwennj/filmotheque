package fr.eni.filmotheque.bll;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.eni.filmotheque.bo.Author;
import fr.eni.filmotheque.dao.AuthorDao;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	private AuthorDao ad;
	public AuthorServiceImpl(AuthorDao ad) {
		this.ad=ad;
	}

	@Override
	public ArrayList<Author> selectAll() {
		// TODO Auto-generated method stub
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
