package facade;

import java.time.LocalDate;
import java.util.List;

import dao.DAO;
import dao.DAOAuthor;
import dao.DAOBook;
import dao.DAOGenre;
import dao.DAOLoan;
import dao.DAOReservation;
import dao.DAOUser;
import model.Author;
import model.Book;
import model.Genre;
import model.Loan;
import model.Reservation;
import model.User;


public class Facade {

	private static DAOAuthor daoAuthor = new DAOAuthor();
	private static DAOBook daoBook = new DAOBook();
	private static DAOGenre daoGenre = new DAOGenre();
	private static DAOLoan daoLoan = new DAOLoan();
	private static DAOReservation daoReservation = new DAOReservation();
	private static DAOUser daoUser = new DAOUser();
	

	public static void inicializar() {
		DAO.open();
	}

	public static void finalizar() {
		DAO.close();
	}
	
	/*=====AUTHOR=====*/
	
	public static Author saveOrUpdateAuthor(String name) throws Exception {
		DAO.begin();
		Author result = daoAuthor.read(name);
		if (result != null) {
			result.setName(name);
			DAO.commit();
			return result;

		} else {
			Author author = new Author(name);
			daoAuthor.create(author);
			DAO.commit();
			return author;
		}
		
	}

	public static void removeAuthor(String authorName) throws Exception {
		DAO.begin();
		Author result = daoAuthor.read(authorName);
		if (result == null) {
			DAO.rollback();
			throw new Exception("Autor " + authorName + " inexistente!");
		}

		daoAuthor.delete(result); // cascata
		DAO.commit();
	}

	public static List<Author> listAuthors() {
		List<Author> list = daoAuthor.readAll();
		return list;
	}
	
	/*=====BOOK=====*/
	
	public static Book saveOrUpdateBook(String title, Integer pages, Genre genre, Author author, Boolean available) throws Exception {
		DAO.begin();
		Book result = daoBook.read(title);
		if (result != null) {
			result.setTitle(title);
			DAO.commit();
			return result;

		} else {
			Book book = new Book(title, pages, genre, author, available);
			daoBook.create(book);
			DAO.commit();
			return book;
		}
	}

	public static void removeBook(String bookTitle) throws Exception {
		DAO.begin();
		Book result = daoBook.read(bookTitle);
		if (result == null) {
			DAO.rollback();
			throw new Exception("Book " + bookTitle + " inexistente!");
		}

		daoBook.delete(result); // cascata
		DAO.commit();
	}

	public static List<Book> listBook() {
		List<Book> list = daoBook.readAll();
		return list;
	}
		
	
	/*=====GENRE=====*/
	
	public static Genre saveOrUpdateGenre(String name) throws Exception {
		DAO.begin();
		Genre result = daoGenre.read(name);
		if (result != null) {
			result.setName(name);
			DAO.commit();
			return result;

		} else {
			Genre genre = new Genre(name);
			daoGenre.create(genre);
			DAO.commit();
			return genre;
		}
	}

	public static void removeGenre(String genreName) throws Exception {
		DAO.begin();
		Genre result = daoGenre.read(genreName);
		if (result == null) {
			DAO.rollback();
			throw new Exception("Genre " + genreName + " inexistente!");
		}

		daoGenre.delete(result); // cascata
		DAO.commit();
	}

	public static List<Genre> listGenre() {
		List<Genre> list = daoGenre.readAll();
		return list;
	}
	
	/*=====LOAN=====*/
	
	public static Loan saveOrUpdateLoan(String id, LocalDate loanDate, User user, Book book, LocalDate devolutionDate, Double loanValue) throws Exception {
		DAO.begin();
		Loan result = daoLoan.read(id);
		if (result != null) {
			daoLoan.update(result);
			DAO.commit();
			return result;

		} else {
			Loan loan = new Loan(id, loanDate, user, book, devolutionDate, loanValue);
			daoLoan.create(loan);
			DAO.commit();
			return loan;
		}
		
	}

	public static List<Loan> listLoan() {
		List<Loan> list = daoLoan.readAll();
		return list;
	}

	
	
	/*=====RESERVATION=====*/
	
	public static Reservation saveOrUpdateReservation(String id, LocalDate loanDate, User user, Book book) throws Exception {
		DAO.begin();
		Reservation result = daoReservation.read(id);
		if (result != null) {
			daoReservation.update(result);
			DAO.commit();
			return result;

		} else {
			Reservation res = new Reservation(id, loanDate, user, book);
			daoReservation.create(res);
			DAO.commit();
			return res;
		}
		
	}

	public static List<Reservation> listReservation() {
		List<Reservation> list = daoReservation.readAll();
		return list;
	}
	
	/*=====USER=====*/

	public static User saveOrUpdateUser(String name, String email, String phone) throws Exception {
		DAO.begin();
		User result = daoUser.read(name);
		if (result != null) {
			result.setEmail(email);
			result.setPhone(phone);
			daoUser.update(result);
			DAO.commit();
			return result;

		} else {
			User u = new User(name, email, phone);
			daoUser.create(u);
			DAO.commit();
			return u;
		}
		
	}

	public static void removeUser(String userName) throws Exception {
		DAO.begin();
		User result = daoUser.read(userName);
		if (result == null) {
			DAO.rollback();
			throw new Exception("Usuário " + userName + " inexistente!");
		}

		daoUser.delete(result); // cascata
		DAO.commit();
	}

	public static List<User> listUsers() {
		List<User> list = daoUser.readAll();
		return list;
	}
}
