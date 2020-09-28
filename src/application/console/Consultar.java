package application.console;

import facade.Facade;

public class Consultar {

	public Consultar(){
		Facade.inicializar();
		try {
			
			System.out.println(Facade.searchBooksByTitle("code"));
			System.out.println(Facade.searchBooksByAuthor("Dan"));
			System.out.println(Facade.searchBooksByGenre("Comedy"));
			
			System.out.println(Facade.searchReservationById("6911bbba-a97a-4a77-9a7b-afc0037e0ed8"));
			System.out.println(Facade.searchLoanById("caf1f2da-b81c-485c-b03e-eb13756a47e6"));
			
			System.out.println(Facade.searchUsersByName("joão"));
			System.out.println(Facade.searchUsersByEmail("chiquinha"));
			
			System.out.println(Facade.listLastLoans());
			System.out.println(Facade.listLastReservations());
			System.out.println(Facade.listNextDevolutions());
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Facade.finalizar();
		System.out.println("Fim das consultas!");
	}



	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}

