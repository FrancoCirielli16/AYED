package tp04.parciales;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	
	public boolean esSeleccion(ArbolGeneral<Integer> a) {
		Integer min = 9999;
		boolean ok = true;
		ArbolGeneral<Integer> aux;
		if(a.esHoja()) {
			return true;
		}
		else {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while ((!hijos.fin())&&(ok)) {
				aux = hijos.proximo();
				min = Math.min(min,aux.getDato());
				ok = esSeleccion(aux);
			}
			if(min == a.getDato()&&(ok)) {
				return true;
			}
			else
				return false;
		}
	}
}
