package dao;

import java.util.List;

import com.db4o.query.Query;

import model.Reservation;

public class DAOReservation extends DAO<Reservation> {
	public Reservation read(Object chave) {
		String id = (String) chave;
		

		Query q = manager.query();
		q.constrain(Reservation.class);
		q.descend("id").constrain(id);
		List<Reservation> resultados = q.execute();
		if (resultados.size() > 0)
			return resultados.get(0);
		else
			return null;
	}

}
