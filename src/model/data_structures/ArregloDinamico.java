package model.data_structures;

import java.util.Arrays;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements ILista<T> {
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private T elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
			elementos =(T[]) new Comparable[max];
			tamanoMax = max;
			tamanoAct = 0;
              
        }
        
		public void agregar( T dato )
		{
			if ( tamanoAct == tamanoMax )
			{  // caso de arreglo lleno (aumentar tamaNo)
				tamanoMax = 2 * tamanoMax;
				T [ ] copia = elementos;
				elementos =(T[]) new Comparable[tamanoMax];
				for ( int i = 0; i < tamanoAct; i++)
				{
					elementos[i] = copia[i];
				} 
				System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
			}	
			elementos[tamanoAct] = dato;
			tamanoAct++;
		}
		
		/**
         * Agrega un elemento al incio de una lista.
         * @param elemento, elemento a agregar.
         */
		public void addFirst(T elemento)
		{
			T[ ] temp = elementos;
			if(tamanoAct == tamanoMax)
				tamanoMax *= 2;

			elementos =(T[]) new Comparable[tamanoMax];
			elementos[0] = elemento;

			for(int i = 0; i < tamanoAct;i++)
				elementos[i+1] = temp[i];

			tamanoAct++;


		}
		/**
         * Agrega un elemento al final de una lista.
         * @param elemento, elemento a agregar.
         */
		public void addLast(T dato)
		{
			if ( tamanoAct == tamanoMax )
			{  
				tamanoMax = 2 * tamanoMax;
				T [ ] copia = elementos;
				elementos =(T[]) new Comparable[tamanoMax];
				for ( int i = 0; i < tamanoAct; i++)
				{
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

		public  T darElemento(int i) {
			return i < tamanoAct && i >= 0? elementos[i]:null;
		}

		
		public T buscar(T dato) {
			int i = 0;
			T a = elementos[0];
			while(i < elementos.length && a != null)
			{
				if(a.compareTo(dato) == 0 )
					return (T) a;
				i++;
				a = elementos[i];
			}

			return null;
			}

		public T eliminar(T dato) {

			int i = 0;
			T resp = null;
			while(i < elementos.length && resp == null)
			{
				T act = elementos[i];
				if(dato.compareTo(act) == 0)
				{
					resp = act;
					elementos[i] = null;
					i--;
				}
				i++;
			}
			if(resp != null)
			{
				while(i+1< elementos.length)
				{
					elementos[i] = elementos[i+1];
					i++;
				}
			}
			return (T) resp;
		}

		public void invertir() {
			T[] copia = elementos;
			elementos = (T[]) new Object[tamanoMax];
			for (int i = 0; i < tamanoAct; i++) {
				elementos[tamanoAct - 1 - i] = copia[i];
			}


		}
		
		
		/**
         * Agrega un elemento en una posicion dada a una lista.
         * @param elemento, elemento a agregar.
         * @param pos, posicion donde se desea agregar el elemento
         */
		public void  insertElement(T element, int pos)
		{
			T[ ] temp = elementos;
			if(tamanoAct == tamanoMax)
				tamanoMax *= 2;

			elementos =(T[]) new Comparable[tamanoMax];
			elementos[pos] = element;

			for(int i = pos; i < tamanoAct;i++)
				elementos[i+1] = temp[i];

			tamanoAct++; 
		}

		/**
         * Elimina el primer elemento de una lista.
         */
		public T removeFirst( )
		{
			T temp = elementos[0];
			elementos[0] = null;

			for(int i = 0; i+1 < tamanoAct && elementos[i+1] != null;i++)
				elementos[i] = elementos[i+1];

			tamanoAct--;
			return temp;
		}
		/**
         * Elimina el ultimo elemento de una lista.
         */
		public T removeLast( )
		{
			T temp = elementos[tamanoAct-1];
			elementos[tamanoAct-1] = null;
			tamanoAct--;
			return temp;
		}
		/**
         * Elimina el ultimo elemento de una lista.
         * @param pos. Elimina un elemento en la posicion dada.
         */
		public T deleteElement(int pos)
		{
			T temp = elementos[pos];
			elementos[pos] = null;

			for(int i = pos; i+1 < tamanoAct;i++)
				elementos[i] = elementos[i+1];

			tamanoAct--;
			return temp;
		}
		/**
         * Retorna el primer elemento de una lista.
         */
		public T firstElement( ) 
		{
			return elementos[0];
		}
		/**
         * Retorna el ultimo elemento de una lista.
         */
		public T lastElement( )
		{
			return tamanoAct > 0 ? elementos[tamanoAct-1] :null;
		}
		/**
         * Retorna true si el arreglo no tiene datos, false en caso contrario.
         */
		public boolean isEmpty()
		{
			return elementos[0] == null?true:false;

		}
	
		/**
         * Retorna la posicion valida de un elemento,En dado caso que no se encuentre retorna -1.
         * @param element. elemento del cual se dese averiguar la posicion.
         */
		public int isPresent (T element) 
		{
			int i = 0;
			int resp = -1;
			while(i < tamanoAct && resp == -1)
			{
				if(elementos[i].equals(element))
					resp = i;
				i++;
			}

			return resp;
		}
		
		/**
         * Intercambia la informacion de los elementos dados en dos posiciones validas.
         * @param pos1. posicion del elemento del cual se desea intercambiar la informacion.
         * @param pos2. posicion del elemento del cual se desea intercambiar la informacion.
         */
		public void exchange (int pos1, int pos2)
		{
			T temp = elementos[pos1];
			elementos[pos1] = elementos[pos2];
			elementos[pos2] = temp;
		}
		/**
         * Actualiza el elemento en una posicion valida.
         * @param pos. posicion del elemento del cual se desea actualizar la informacion.
         * @param elem. elemento al cual se le desea actualizar la informacion.
         */
		public void changeInfo (int pos, T elem)
		{
			elementos[pos] = elem;
		}

		}
