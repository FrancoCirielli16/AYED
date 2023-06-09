package tp04.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RecorridosAG {
	
	
	private	void numerosImparesMayoresQuePreOrden (ArbolGeneral<Integer> a, Integer n,ListaGenerica<Integer> l){
		if(!a.esVacio()) {
			if(a.getDato() % 2 == 1 & a.getDato() > n) {
				l.agregarFinal(a.getDato());
			}
			if(a.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> Hijos = a.getHijos();
				Hijos.comenzar();
				while(!Hijos.fin()) {
					numerosImparesMayoresQuePreOrden(Hijos.proximo(),n,l);
				}
			}
		}
		
	}
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden (ArbolGeneral<Integer> a, Integer n){
		ListaEnlazadaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQuePreOrden(a,n,l);
		return l;
		
	}
			

	private void numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a,Integer  n,ListaGenerica<Integer> l) {
		ListaGenerica<ArbolGeneral<Integer>> Hijos = a.getHijos();
		Hijos.comenzar();
		if(!Hijos.esVacia()) 
			numerosImparesMayoresQueInOrden(Hijos.proximo(),n,l);
		if(a.getDato() % 2 == 1 & a.getDato()>n) {
				l.agregarFinal(a.getDato());
		}
		if(a.tieneHijos()) {
			while(!Hijos.fin()) {
				numerosImparesMayoresQueInOrden(Hijos.proximo(),n,l);
			}
		}
	}
	
	
	public ListaGenerica< Integer > numerosImparesMayoresQueInOrden (ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQueInOrden(a,n,l);
		return l;
	}
	
	private void numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n,ListaGenerica<Integer> l) {
		if(!a.esVacio()) {
			if(a.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> Hijos = a.getHijos();
				Hijos.comenzar();
				while(!Hijos.fin()) {
					numerosImparesMayoresQuePostOrden(Hijos.proximo(),n,l);
				}
			}
			if(a.getDato() % 2 == 1 & a.getDato()>n) {
				l.agregarFinal(a.getDato());
			}
		}
	}
	
	public ListaGenerica< Integer > numerosImparesMayoresQuePostOrden (ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQuePostOrden(a,n,l);
		return l;
	}
	
	
	
	public ListaGenerica< Integer > numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> aux;
		cola.apilar(a);
		cola.apilar(null);
		while(!cola.esVacia()) {
			
			aux=cola.desapilar();
			if(aux!=null){
				
				if((aux.getDato() % 2 == 1) && (aux.getDato()>n)) {
					l.agregarFinal(aux.getDato());
				}
				
				if(aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Integer>> Hijos= aux.getHijos();
					Hijos.comenzar();
					while(!Hijos.fin()) {
						cola.apilar(Hijos.proximo());
					}
				}
			}
			else {
				
				if (!cola.esVacia())
					cola.apilar(null);	
			}
		}
		return l;
	}
	
	
	
}

