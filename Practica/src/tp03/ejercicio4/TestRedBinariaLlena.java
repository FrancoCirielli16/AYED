package tp03.ejercicio4;

import tp03.ejercicio1.ArbolBinario;

public class TestRedBinariaLlena {
	public static void main(String[] args) {
		 //           14
        //         /    \
        //        3     2
        //       / \    / \
        //      12  9  33 102
		
		ArbolBinario<Integer> catorce = new ArbolBinario(14);
		ArbolBinario<Integer> tres  = new ArbolBinario(3);
		ArbolBinario<Integer> dos = new ArbolBinario(2);
		ArbolBinario<Integer> doce = new ArbolBinario(12);
		ArbolBinario<Integer> nueve = new ArbolBinario(9);
		ArbolBinario<Integer> treintaYtres = new ArbolBinario(33);
		ArbolBinario<Integer> cientoDos = new ArbolBinario(102);
		
		catorce.agregarHijoIzquierdo(tres);
		catorce.agregarHijoDerecho(dos);
		tres.agregarHijoIzquierdo(doce);
		tres.agregarHijoDerecho(nueve);
		dos.agregarHijoIzquierdo(treintaYtres);
		dos.agregarHijoDerecho(cientoDos);
		
		RedBinariaLlena red = new RedBinariaLlena(catorce);
		
		System.out.println("El mayor retardo es de "+red.retardoReenvio()+" segs");	
	}

}

