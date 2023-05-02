package tp03.parcialesAB.impares;

import tp03.ejercicio1.ArbolBinario;

public class Parcial {
		
	ArbolBinario<Integer> A;

	private boolean resolver(ArbolBinario<Integer> a,int k,int suma){
		boolean esMonodistante = true;
		suma += A.getDato();
		
		if(a.esHoja()) {
			esMonodistante = suma == k;
		}
		else {
			if(a.tieneHijoIzquierdo()) {
				esMonodistante = resolver(a.getHijoIzquierdo(),k,suma);
			}
			if ((esMonodistante)&&(a.tieneHijoDerecho())){
				esMonodistante = resolver(a.getHijoDerecho(),k,suma);
			}
		}
		return esMonodistante;
	}
		public boolean resolver(int k) {
			int suma = 0;
			return resolver(this.A,k,suma);
		}
	}

