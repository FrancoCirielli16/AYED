package tp04.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {
	
	public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa>arbol) {
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
		ArbolGeneral<AreaEmpresa> aux;
		Integer max=-1,suma=0,promedio=0,nivel=0,cant=0;
		cola.apilar(arbol);
		cola.apilar(null);
		while(!cola.esVacia()) {
			aux=cola.desapilar();
			if(aux != null) {
				cant++;
				suma+=aux.getDato().getTime();
				if(aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = aux.getHijos();
					hijos.comenzar();
					while(!hijos.fin()) {
						cola.apilar(hijos.proximo());
					}
				}
			}
			else {
				promedio=suma/cant;
				if(promedio>max) {
					max=promedio;
				}
				if(!cola.esVacia()) {
					cola.apilar(null);
					nivel++;
				}
			}
		}
		return max;
	}
}
