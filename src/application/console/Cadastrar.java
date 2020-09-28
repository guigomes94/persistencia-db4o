package application.console;

import facade.Facade;
import model.Author;
import model.Book;
import model.Genre;
import model.User;

public class Cadastrar {

	public Cadastrar() {
		Facade.inicializar();
		cadastrar();
		Facade.finalizar();
	}

	public void cadastrar() {
		try {
			System.out.println("Cadastrando autores...");
			
			Author author1 = Facade.saveOrUpdateAuthor("Robert C. Martin");
			Author author2 = Facade.saveOrUpdateAuthor("Martin Fowler");
			Author author3 = Facade.saveOrUpdateAuthor("Dan Brown");
			Author author4 = Facade.saveOrUpdateAuthor("Andrew S. Tanenbaum");
			Author author5 = Facade.saveOrUpdateAuthor("Léo Lins");
			
			
			System.out.println("\nCadastrando generos...");
			
			Genre genre1 = Facade.saveOrUpdateGenre("Comedy");
			Genre genre2 = Facade.saveOrUpdateGenre("Fiction");
			Genre genre3 = Facade.saveOrUpdateGenre("Technology");
			
			System.out.println("\nCadastrando usuários...");
			
			User u1 = Facade.saveOrUpdateUser("João Pessoa", "joao@gmail.com", "987882222");
			User u2 = Facade.saveOrUpdateUser("Chiquinha", "chiquinha@gmail.com", "988883333");
			User u3 = Facade.saveOrUpdateUser("Maria Florinda", "florinda@gmail.com", "999887755");
			
			System.out.println("\nCadastrando livros...");
			
			Book b1 = Facade.saveOrUpdateBook("O Livro dos Insultos", 127, genre1, author5);
			Book b2 = Facade.saveOrUpdateBook("Inferno", 380, genre2, author3);
			Book b3 = Facade.saveOrUpdateBook("Clean Code", 447, genre3, author1);
			

			System.out.println("\nCadastro inicial realizado com sucesso!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// =================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}
