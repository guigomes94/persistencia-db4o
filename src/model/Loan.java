package model;

import java.time.LocalDate;

public class Loan {
	
	private String id;
	private LocalDate loanDate;
	private User user;
	private Book book;
	private LocalDate devolutionDate;
	private Double loanValue;
	
	public Loan() {
		
	}

	public Loan(String id, LocalDate loanDate, User user, Book book, LocalDate devolutionDate, Double loanValue) {
		this.id = id;
		this.loanDate = loanDate;
		this.user = user;
		this.book = book;
		this.devolutionDate = devolutionDate;
		this.loanValue = loanValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(LocalDate devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	public Double getLoanValue() {
		return loanValue;
	}

	public void setLoanValue(Double loanValue) {
		this.loanValue = loanValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", loanDate=" + loanDate + ", user=" + user.getName() + ", book=" + book.getTitle() + ", devolutionDate="
				+ devolutionDate + ", loanValue=" + loanValue + "]";
	}
	
	
	
	
		
}
