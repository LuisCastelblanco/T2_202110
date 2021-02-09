package model.data_structures;

/**
 * 2019-01-23 Estructura de Datos Arreglo Dinamico de Strings. El arreglo al
 * llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * 
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la
	 * posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private String elementos[];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * 
	 * @param max
	 *            Capacidad maxima inicial
	 */
	public ArregloDinamico(int max) {
		elementos = new String[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar(String dato) {
		if (tamanoAct == tamanoMax) { // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			String[] copia = elementos;
			elementos = new String[tamanoMax];
			for (int i = 0; i < tamanoAct; i++) {
				elementos[i] = copia[i];
			}
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public String darElemento(int i) {
		return elementos[i].toString();
	}

	/**
	 * Metodo que busca el dato generico dado
	 * 
	 * @param dato
	 * @return
	 */
	public T buscar(T dato) {

		T solucion = null;
		boolean encontro = false;
		for (int i = 0; i < tamanoAct && !encontro; i++) {
			if (elementos[i].compareTo(dato) == 0) {
				encontro = true;
				solucion = elementos[i];
			}
		}
		return solucion;
	}
	/**
	 * Metodo que elimina el dato generico dado
	 * @param dato
	 * @return 
	 */
	public T eliminar(T dato) {
		boolean encontro = false;
		for (int i = 0; i < tamanoAct && !encontro; i++) {
			if (elementos[i].compareTo(dato) == 0) {
				encontro = true;
				elementos[i] = null;
			}
		}
		return null;
	}
	/**
	 * Metodo que invierte la lista generica
	 */
	public void invertir() {
		T[] copia = elementos;
		elementos = (T[]) new Object[tamanoMax];
		for (int i = 0; i < tamanoAct; i++) {
			elementos[tamanoAct - 1 - i] = copia[i];
		}

	}

}
