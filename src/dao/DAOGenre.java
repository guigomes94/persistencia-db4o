package dao;

import java.util.List;

import com.db4o.query.Query;

import model.Genre;

public class DAOGenre extends DAO<Genre> {
	public Genre read(Object chave) {
		String name = (String) chave;
		

		Query q = manager.query();
		q.constrain(Genre.class);
		q.descend("name").constrain(name);
		List<Genre> resultados = q.execute();
		if (resultados.size() > 0)
			return resultados.get(0);
		else
			return null;
	}

}
