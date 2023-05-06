package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		Integer altura=-1;
		if(this.esHoja())
			return 0;
		if(this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos= this.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				altura = Math.max(altura, hijos.proximo().altura());
			}
			
		}
		return altura + 1;
	}

	public Integer nivel(T dato) {
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T>aux;
		cola.apilar(this);
		cola.apilar(null);
		Integer nivel=0;
		while(!cola.esVacia()) {
			aux=cola.desapilar();
			if(aux!=null) {
				if(aux.getDato() == dato) {
					return nivel;
				}
				if(aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos=aux.getHijos();
					hijos.comenzar();
					while(!hijos.fin()) {
						cola.apilar(hijos.proximo());
					}
				}
				
			}else {
				if(!cola.esVacia()) {
					cola.apilar(null);
					nivel++;
				}
			}
		}
		return -1;
	}

	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T>aux;
		cola.apilar(this);
		cola.apilar(null);
		Integer max = -1,cantidad = -1,nivel = 0;
		while(!cola.esVacia()) {
			aux = cola.desapilar();
			if(aux!=null) {
				cantidad++;
				if(aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>>hijos=aux.getHijos();
					hijos.comenzar();
					while(!hijos.fin()) {
						cola.apilar(hijos.proximo());
					}
				}
			}
			else {
				if(cantidad>max) 
					max=cantidad;
				cantidad=0;
				if(!cola.esVacia()) {
					cola.apilar(null);
					nivel++;
				}
			}
		}
		return max;
	}
	
	public boolean esPrincesa() {
		return this.dato.equals("princesa");
	}
	
	
	public boolean esDragon() {
		return this.dato.equals("dragon");
	}
	
	
}