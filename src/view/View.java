package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("Seleccione la opcion a su gusto.");
			System.out.println("Opcion1. Ver informaci�n b�sica de la primer y �ltimo video en una lista de los archivos ademas de, el total de videos encontrados en las fuentes");
			System.out.println("Opcion2. Ver informaci�n b�sica de la primer y �ltimo video en un arreglo de los archivos ademas de, el total de videos encontrados en las fuentes");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
		}
}
