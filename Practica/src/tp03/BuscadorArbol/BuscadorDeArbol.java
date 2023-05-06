package tp03.BuscadorArbol;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class BuscadorDeArbol {
	private ArbolBinario<Integer> a;
	
	
	public void setA(ArbolBinario<Integer> a) {
		this.a = a;
	}

	public Integer buscar() {
		Integer MayorProfundidad = -1;
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		if(!this.a.esVacio()) {
			buscar(a,l,0,-9999);
			l.comenzar();
			return l.proximo();
		}
		return MayorProfundidad;
	}
	
	private Integer buscar (ArbolBinario<Integer> a,ListaGenerica<Integer> l,Integer altura,Integer max) {
		if(a.esHoja()) {
			if(altura > max) {
				max = altura;
				l.agregarInicio(a.getDato());
			}
		}else {
			
			if(a.tieneHijoIzquierdo()) {
				max = Math.max(max,buscar(a.getHijoIzquierdo(),l,altura+1,max));
			}
			if(a.tieneHijoDerecho()) {
				max = Math.max(max,buscar(a.getHijoDerecho(),l,altura+1,max));
			}
		}
		return max;
	}
}
