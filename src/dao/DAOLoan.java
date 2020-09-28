package dao;

import java.time.LocalDate;
import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import model.Loan;

public class DAOLoan extends DAO<Loan> {

	public Loan read(Object chave) {
		String id = (String) chave;

		Query q = manager.query();
		q.constrain(Loan.class);
		q.descend("id").constrain(id);
		List<Loan> resultados = q.execute();
		if (resultados.size() > 0)
			return resultados.get(0);
		else
			return null;
	}

	/**********************************************************
	 * 
	 * CONSULTAS DE LOAN
	 * 
	 **********************************************************/

	public List<Loan> readLoansById(String id) {
		Query q = manager.query();
		q.constrain(Loan.class);
		q.descend("id").constrain(id);
		List<Loan> result = q.execute();
		return result;
	}

	public List<Loan> readLastLoans() {

		Query q = manager.query();
		q.constrain(Loan.class);
		q.constrain(new DateFilterLastLoans());
		List<Loan> result = q.execute();
		return result;
	}

	public List<Loan> readNextDevolutions() {

		Query q = manager.query();
		q.constrain(Loan.class);
		q.constrain(new DateFilterNextDevolutions());
		List<Loan> result = q.execute();
		return result;
	}

	@SuppressWarnings("serial")
	class DateFilterLastLoans implements Evaluation {

		LocalDate today = LocalDate.now();
		LocalDate lastSevenDays = today.minusDays(7);

		@Override
		public void evaluate(Candidate candidate) {
			Loan loan = (Loan) candidate.getObject();
			Boolean filter = loan.getLoanDate().isBefore(today) && loan.getLoanDate().isAfter(lastSevenDays);
			candidate.include(filter);

		}

	}
	
	@SuppressWarnings("serial")
	class DateFilterNextDevolutions implements Evaluation {

		LocalDate today = LocalDate.now();
		LocalDate nextSevenDays = today.plusDays(7);

		@Override
		public void evaluate(Candidate candidate) {
			Loan loan = (Loan) candidate.getObject();
			Boolean filter = loan.getDevolutionDate().isAfter(today) && loan.getDevolutionDate().isBefore(nextSevenDays);
			candidate.include(filter);

		}

	}

}
