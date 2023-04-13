package tp03.ejercicio4;

import tp03.ejercicio1.ArbolBinario;

public class RedBinariaLlena {
	private ArbolBinario<Integer> arbol; 
	
	public RedBinariaLlena(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int retardoReenvio() {
		return retardoReenvio(this.arbol);
	}
	
	private int retardoReenvio(ArbolBinario<Integer> arbol) {
		int cant=0;
			
		if(arbol.esHoja())
			return arbol.getDato();
		else {
			cant = Math.max(cant, retardoReenvio(arbol.getHijoIzquierdo()));
			cant = Math.max(cant, retardoReenvio(arbol.getHijoDerecho()));
		}
	
		return cant + arbol.getDato();
			
	}
}
