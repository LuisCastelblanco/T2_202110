package controller;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		int dato = -1;
		String respuesta = "";
		modelo = new Modelo(10000);
		modelo.CargarArchivosArreglo();
		modelo.CargarArchivosLista();

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
			    
				view.printMessage("Bienvenido, los datos iniciales son:");
			    view.printMessage("Datos primer video: " + modelo.darVideosLista().firstElement().datosBasicos());
			    view.printMessage("Datos ultimo video: " + modelo.darVideosLista().lastElement().datosBasicos());
			    view.printMessage("La cantidad total de videos es: " + modelo.darTamano());
				break;
				
				
				
			case 2:
				
				view.printMessage("Bienvenido, los datos iniciales son:");
			    view.printMessage("Datos primera pelicula: " + modelo.darVideosArreglo().firstElement().datosBasicos());
			    view.printMessage("Datos ultima pelicula: " + modelo.darVideosArreglo().lastElement().datosBasicos());
			    view.printMessage("La cantidad total de peliculas es: " + modelo.darTamano());
				break;

				
				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
