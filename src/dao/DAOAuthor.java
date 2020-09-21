package dao;

import java.util.List;

import com.db4o.query.Query;

import model.Author;

public class DAOAuthor extends DAO<Author> {
	public Author read(Object chave) {
		String name = (String) chave;
		

		Query q = manager.query();
		q.constrain(Author.class);
		q.descend("name").constrain(name);
		List<Author> resultados = q.execute();
		if (resultados.size() > 0)
			return resultados.get(0);
		else
			return null;
	}

}
