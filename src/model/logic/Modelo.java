package model.logic;

import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;
	
	private ILista<T> datosVideos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ArregloDinamico(7);
		datosVideos= new ListaEncadenada<T>;
	}
	
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico(capacidad);
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		datos.agregar(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Comparable buscar(String dato)
	{
		return datos.buscar(dato);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Comparable eliminar(String dato)
	{
		return datos.eliminar(dato);
	}
	/**
	 * Metodo que carga los datos de los videos
	 */
	public void cargar(String[] args){
		
		Reader in = new FileReader("/esqueleto_T0_202010/data/videos-small.csv");
		
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		for (CSVRecord record : records) {
		    String PrimerVideo = record.get(1);
		    String UltimoVideo = record.get(record.size());
		    int TotalVideos= record.size();
		    
		    
		    datos.agregar(PrimerVideo);
		    datosVideos.agregar(PrimerVideo);
		    datos.agregar(UltimoVideo);
		    datosVideos.agregar(UltimoVideo);
		    datos.agregar(TotalVideos);
		    datosVideos.agregar(TotalVideos);
		    
		    
		}
	}
	.
}
