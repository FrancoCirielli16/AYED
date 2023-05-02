package tp03.parcialesAB.impares;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;


public class Resultado {
	public Integer cantImpares;
	public ListaGenerica<Integer> l;
	
	public Resultado(Integer cantImpares,ListaGenerica<Integer> l) {
		this.cantImpares = cantImpares;
		this.l = l; 
	}
}


public class ProcesadorDeArbol {
	private ArbolBinario<Integer> A;
	
	
	private Integer procesar(ArbolBinario<Integer> arbol ,ListaGenerica<Integer> l) {
		Integer impares = 0;
		if(!arbol.esHoja()) {
			if(arbol.tieneHijoIzquierdo()) {
				impares += procesar(arbol.getHijoIzquierdo(),l);
			}
			if(arbol.tieneHijoDerecho()) {
				impares += procesar(arbol.getHijoDerecho(),l);
			}
			if(arbol.getDato() % 2 != 0) {
				impares += 1;
				if (
						(!arbol.tieneHijoDerecho() && arbol.tieneHijoIzquierdo()) || 
						(arbol.tieneHijoDerecho() && !arbol.tieneHijoIzquierdo())
						){
					l.agregarFinal(arbol.getDato());
					
				}
			}
		}
		return impares;
	}
	
	public Resultado procesar(ListaGenerica<Integer> l) {
		l = new ListaEnlazadaGenerica<Integer>();
		Resultado r = new Resultado(procesar(this.A,l),l);
		return r;
	}
}
