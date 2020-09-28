package dao;

import java.util.List;

import com.db4o.query.Query;

import model.Book;

public class DAOBook extends DAO<Book> {
	
	public Book read(Object chave) {
		String title = (String) chave;

		Query q = manager.query();
		q.constrain(Book.class);
		q.descend("title").constrain(title);
		List<Book> resultados = q.execute();
		if (resultados.size() > 0)
			return resultados.get(0);
		else
			return null;
	}
	
	/**********************************************************
	 * 
	 * CONSULTAS DE BOOK
	 * 
	 **********************************************************/
	public List<Book> readBooksAvailable() {
		Query q = manager.query();
		q.constrain(Book.class);
		q.descend("available").constrain(true);
		List<Book> result = q.execute(); 
		return result;
	}
	
	public List<Book> readBooksByTitle(String caracteres) {
		Query q = manager.query();
		q.constrain(Book.class);
		q.descend("title").constrain(caracteres).like();
		List<Book> result = q.execute(); 
		return result;
	}
	
	public List<Book> readBooksByAuthor(String author) {
		Query q = manager.query();
		q.constrain(Book.class);
		q.descend("author").descend("name").constrain(author).like();
		List<Book> result = q.execute();
		return result;
	}
	
	public List<Book> readBooksByGenre(String genre) {
		Query q = manager.query();
		q.constrain(Book.class);
		q.descend("genre").descend("name").constrain(genre).like();
		List<Book> result = q.execute();
		return result;
	}

}
