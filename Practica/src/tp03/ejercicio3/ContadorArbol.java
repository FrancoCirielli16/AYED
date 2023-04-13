package tp03.ejercicio3;

import tp02.ejercicio1.ListaDeEnteros;
import tp02.ejercicio1.ListaDeEnterosEnlazada;
import tp03.ejercicio1.*;

public class ContadorArbol {
	private ArbolBinario<Integer> arbol;

	private void inOrden(ArbolBinario<Integer> arbol,ListaDeEnteros l) {
		if (!this.arbol.esVacio()) {
			
			if (this.arbol.tieneHijoIzquierdo()) {
				this.inOrden(arbol.getHijoIzquierdo(), l);
			}
			
			if (this.arbol.getDato() % 2 == 0) {
				l.agregarFinal(arbol.getDato());
			}
			
			if (this.arbol.tieneHijoDerecho()) {
				this.inOrden(arbol.getHijoDerecho(), l);
			}
			
		}
		
	}
	
	
	private void postOrden(ArbolBinario<Integer> arbol,ListaDeEnteros l) {
		if (!this.arbol.esVacio()) {
			
			if (this.arbol.tieneHijoIzquierdo()) {
				this.inOrden(arbol.getHijoIzquierdo(), l);
			}
			
			if (this.arbol.tieneHijoDerecho()) {
				this.inOrden(arbol.getHijoDerecho(), l);
			}
			
			if (this.arbol.getDato() % 2 == 0) {
				l.agregarFinal(arbol.getDato());
			}
		}
		
	}
	
	
	public ListaDeEnteros numerosParesInOrden() {
		ListaDeEnteros pares = new ListaDeEnterosEnlazada();
		
		if(this.arbol != null) {
			this.inOrden(this.arbol,pares);
		}
		return pares;
	}
	
	public ListaDeEnteros numerosParesPostOrden() {
		ListaDeEnteros pares = new ListaDeEnterosEnlazada();
		
		if(this.arbol != null) {
			this.postOrden(arbol, pares);
		}
		return pares;
	}

}
