package application.console;

import facade.Facade;

public class Listar {
	
	public Listar(){
		Facade.inicializar();
		try {
			Facade.listUsers().stream().forEach(System.out::println);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Facade.finalizar();
		System.out.println("Usuários Listados");
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}

}
