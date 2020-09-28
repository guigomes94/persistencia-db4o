package dao;

import java.time.LocalDate;
import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
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
	
	/**********************************************************
	 * 
	 * CONSULTAS DE RESERVATION
	 * 
	 **********************************************************/
	
	public List<Reservation> readReservationsById(String id) {
		Query q = manager.query();
		q.constrain(Reservation.class);
		q.descend("id").constrain(id);
		List<Reservation> result = q.execute(); 
		return result;
	}
	
	public List<Reservation> readLastReservations() {

		Query q = manager.query();
		q.constrain(Reservation.class);
		q.constrain(new DateFilterLastReservations());
		List<Reservation> result = q.execute();
		return result;
	}
	
	@SuppressWarnings("serial")
	class DateFilterLastReservations implements Evaluation {

		LocalDate today = LocalDate.now();
		LocalDate lastSevenDays = today.minusDays(7);

		@Override
		public void evaluate(Candidate candidate) {
			Reservation reservation = (Reservation) candidate.getObject();
			Boolean filter = reservation.getReservationDate().isBefore(today) && reservation.getReservationDate().isAfter(lastSevenDays);
			candidate.include(filter);

		}

	}

}
