package model;

import java.time.LocalDate;

public class Reservation {
	
	private String id;
	private LocalDate reservationDate;
	private User user;
	private Book book;
	
	public Reservation() {
		
	}
	
	public Reservation(String id, LocalDate reservationDate, User user, Book book) {
		this.id = id;
		this.reservationDate = reservationDate;
		this.user = user;
		this.book = book;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
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
		Reservation other = (Reservation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", reservationDate=" + reservationDate + ", user=" + user.getName() + ", book=" + book.getTitle()
				+ "]";
	}
	
}
