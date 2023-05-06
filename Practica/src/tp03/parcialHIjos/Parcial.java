package tp03.parcialHIjos;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class Parcial {

	public ListaGenerica<Integer> resolver(ArbolBinario<Integer> a){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		if(a.esVacio()) {
			return l;
		}
		resolver(a,l);
		return l;
	}
	
	private int resolver(ArbolBinario<Integer> a, ListaGenerica<Integer> l) {
		int HD = 0;
		int HI = 0;
		int cant = 0;
		if(a.esHoja()) {
			cant = 1;
		}else {
			if(a.tieneHijoIzquierdo()) {
				HI += resolver(a.getHijoIzquierdo(),l);
			}
			if(a.tieneHijoDerecho()) {
				HD += resolver(a.getHijoDerecho(),l);
			}
			cant = HI + HD + 1;
		}
		if(HD == HI)
			l.agregarFinal(a.getDato());
		return cant;
	}
}
