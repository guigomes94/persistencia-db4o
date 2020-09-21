package dao;

import java.util.List;

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

}
