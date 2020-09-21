package application.console;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import facade.Facade;


public class Deletar {

	public Deletar(){
		Facade.inicializar();
		try {
			System.out.println("deletando...");
			Facade.removeUser("maria");
			System.out.println("deletou maria");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Facade.finalizar();
		System.out.println("fim do programa");
	}



	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

