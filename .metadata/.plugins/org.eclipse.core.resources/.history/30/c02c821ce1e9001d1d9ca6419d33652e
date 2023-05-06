package tp03.parcialesAB.impatringres;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ParcialCAMINOS {
	
	private boolean resolver(ArbolBinario<Integer> a,ListaGenerica<Integer> l,Integer min,Integer pares) {
		boolean esCamino = true;
		l.agregarFinal(a.getDato());
		if(a.getDato() % 2 == 0) {
			pares+=1;
		}
		if(a.esHoja()) {
			if(pares >= min) {
				return false;
			}
			else {
				l.eliminarEn(l.tamanio());
				return true;
			}
		}
		else {
			if(a.tieneHijoIzquierdo()) {
				esCamino = resolver(a.getHijoIzquierdo(),l,min,pares);
			}
			if((esCamino)&&(a.tieneHijoDerecho())){
				esCamino = resolver(a.getHijoDerecho(),l,min,pares);
			}
			if(esCamino) {
				l.eliminarEn(l.tamanio());
			}
		}
	
		return esCamino;
	}
	
	
	
	public ListaGenerica<Integer> resolver(ArbolBinario<Integer> a, Integer min){
		ListaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();
		if(!a.esVacio()) {
			resolver(a,l,min,0);
		}		
		return l;
		
	}
	
	
}