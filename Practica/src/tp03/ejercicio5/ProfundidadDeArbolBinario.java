package tp03.ejercicio5;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> arbol;
	
    public void setArbol(ArbolBinario<Integer> arbol){
        this.arbol = arbol;
    }
	
	public int sumaElementosProfundidad(int p) {
		int suma=0;
		ArbolBinario<Integer> a;
		ColaGenerica <ArbolBinario<Integer>> cola = new ColaGenerica<>();
		cola.apilar(arbol);
		cola.apilar(null);
		if (arbol.esVacio()) {
			return -1;
		}
		boolean ok = false;
		int nivel = 0;
		while(!cola.esVacia()&&!ok) {
			a = cola.desapilar();
			if(a != null) {
				if(nivel == p)
					suma+=a.getDato();
				if(a.tieneHijoIzquierdo())
					cola.apilar(a.getHijoIzquierdo());
				if(a.tieneHijoDerecho())
					cola.apilar(a.getHijoDerecho());
			}
			else {
				if(!cola.esVacia()) {
					cola.apilar(null);
					nivel++;
				}
			}
			if (nivel > p) 
				ok = true;
		}
		return suma;
	}
}
