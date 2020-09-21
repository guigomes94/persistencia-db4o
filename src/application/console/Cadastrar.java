package application.console;

import facade.Facade;

public class Cadastrar {

	public Cadastrar() {
		Facade.inicializar();
		cadastrar();
		Facade.finalizar();
	}

	public void cadastrar() {
		try {
			System.out.println("cadastrando...");

			Facade.saveOrUpdateUser("joao", "joao@gmail.com", "87882222");
			Facade.saveOrUpdateUser("maria", "maria@gmail.com", "88883333");
			Facade.saveOrUpdateUser("jose", "jose@gmail.com", "87884444");

			System.out.println("OK");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// =================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}
