package tp04.princesa;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Princesa {
	
	public ListaGenerica<Personaje> buscar(ArbolGeneral<Personaje>a){
		ListaGenerica<Personaje> l = new ListaEnlazadaGenerica<Personaje>();	
		if(a.esVacio()) {
			return l;
		}
		buscar(a,l);
		return l;
	}
	
	private boolean buscar(ArbolGeneral<Personaje>a,ListaGenerica<Personaje> l) {
		boolean encontre = false;
		
		if(a.esPrincesa()) {
			l.agregarInicio(a.getDato());
			return true;
		}else {
			if(!a.esDragon()){			
				if(a.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Personaje>> hijos = a.getHijos();
					hijos.comenzar();
					while(!hijos.fin()&&(!encontre)){
						encontre = buscar(hijos.proximo(),l);
						if(encontre) {
							l.agregarInicio(a.getDato());
						}
					}
				}
			}
		}
		
		return encontre;
	}
}
