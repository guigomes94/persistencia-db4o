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

}
