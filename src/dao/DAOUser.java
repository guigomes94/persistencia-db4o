package dao;

import java.util.List;

import com.db4o.query.Query;

import model.User;

public class DAOUser extends DAO<User> {
	
	public User read(Object chave) {
		String name = (String) chave;

		Query q = manager.query();
		q.constrain(User.class);
		q.descend("name").constrain(name);
		List<User> resultados = q.execute();
		if (resultados.size() > 0)
			return resultados.get(0);
		else
			return null;
	}
	
	/**********************************************************
	 * 
	 * CONSULTAS DE USER
	 * 
	 **********************************************************/
	
	public List<User> readUsersByName(String name) {
		Query q = manager.query();
		q.constrain(User.class);
		q.descend("name").constrain(name).like();
		List<User> result = q.execute(); 
		return result;
	}
	
	public List<User> readUsersByEmail(String email) {
		Query q = manager.query();
		q.constrain(User.class);
		q.descend("email").constrain(email).like();
		List<User> result = q.execute(); 
		return result;
	}

}
