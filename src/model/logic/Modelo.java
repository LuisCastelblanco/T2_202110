
package model.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import model.data_structures.ArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.ListaEcadenada;
import model.data_structures.ListaEcadenada;
/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	public static final String SEPARATOR=",";
	private ILista datosVideo;
	
	private ArregloDinamico<VideoYoutube>videos;
	
	private ListaEcadenada<VideoYoutube> videosLista; 
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		
	}

	public Modelo(int tamano)
	{
		videos = new ArregloDinamico<VideoYoutube>(tamano);
		videosLista = new ListaEcadenada<VideoYoutube>();
	}
	
	public ArregloDinamico<VideoYoutube> darVideosArreglo()
	{
		return videos;
	}

	public ListaEcadenada<VideoYoutube>darVideosLista(){
		return videosLista;
	}
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return videos.darTamano();
	}
	
	

	
	
	public void CargarArchivosArreglo()
	{

		BufferedReader bufferLectura = null;

		try{
			bufferLectura = new BufferedReader(new FileReader("./data/videos-all.csv"));

			String linea = bufferLectura.readLine();
			linea = bufferLectura.readLine();
			while (linea!= null)
			{
				String[] campos = linea.split(SEPARATOR);
				
				VideoYoutube temp = new VideoYoutube(campos[0], campos[1], campos[2], campos[3].trim(), Integer.parseInt(campos[4].trim()), campos[5].trim(), campos[6], Integer.parseInt(campos[7].trim()) , Integer.parseInt(campos[8].trim()),Integer.parseInt(campos[9].trim()), Integer.parseInt(campos[10].trim()), campos[11], false, false, false, campos[15],campos[16]);
				videos.agregar(temp);
				linea = bufferLectura.readLine();
			}
			bufferLectura.close();

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		finally 
		{
			if( bufferLectura != null)
			{
				try
				{
					bufferLectura.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	public void CargarArchivosLista()
	{

		BufferedReader bufferLectura = null;

		try{
			bufferLectura = new BufferedReader(new FileReader("./data/videos-all.csv"));

			String linea = bufferLectura.readLine();
			linea = bufferLectura.readLine();
			while (linea!= null)
			{
				String[] campos = linea.split(SEPARATOR);
				VideoYoutube temp = new VideoYoutube(campos[0], campos[1], campos[2], campos[3].toString(), Integer.parseInt(campos[4].trim()), campos[5].trim(), campos[6], Integer.parseInt(campos[7].trim()) , Integer.parseInt(campos[8].trim()),Integer.parseInt(campos[9].trim()), Integer.parseInt(campos[10].trim()), campos[11], false, false, false, campos[15],campos[16]);
				videosLista.addLast(temp);
				linea = bufferLectura.readLine();
			}
			bufferLectura.close();

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if( bufferLectura != null)
			{
				try
				{
					bufferLectura.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * Metodo que carga los datos de los videos
	 * @throws IOException 
	 */
	public void cargar(String[] args) throws IOException{
		
		Reader in = new FileReader("/esqueleto_T0_202010/data/videos-small.csv");
		
       Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		for (CSVRecord record : records) {
		    String PrimerVideo = record.get(1);
		    String UltimoVideo = record.get(record.size());
		    int TotalVideos= record.size();
		    
		    
		    datosVideo.agregar(PrimerVideo);
		   // videosLista.agregar(PrimerVideo);
		    datosVideo.agregar(UltimoVideo);
		  //  videosLista.addLast(UltimoVideo);
		    datosVideo.agregar(TotalVideos);
		 //   videosLista.agregar(TotalVideos);
	}
		    
		}
}

