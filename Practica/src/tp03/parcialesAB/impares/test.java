package tp03.parcialesAB.impares;

import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;
import tp03.parcialesAB.impatringres.ParcialCAMINOS;

public class test {
	public static void main(String[] arg) {
        
		ArbolBinario<Integer> catorce = new ArbolBinario(14);     
		ArbolBinario<Integer> tres  = new ArbolBinario(2);        
		ArbolBinario<Integer> dos = new ArbolBinario(2);          
		ArbolBinario<Integer> doce = new ArbolBinario(11);        
		ArbolBinario<Integer> nueve = new ArbolBinario(4);        
		ArbolBinario<Integer> treintaYtres = new ArbolBinario(33);
		ArbolBinario<Integer> cientoDos = new ArbolBinario(102);  
		                                                          
		catorce.agregarHijoIzquierdo(tres);                       
		catorce.agregarHijoDerecho(dos);                          
		tres.agregarHijoIzquierdo(doce);                          
		tres.agregarHijoDerecho(nueve);                           
		dos.agregarHijoIzquierdo(treintaYtres);                   
		dos.agregarHijoDerecho(cientoDos);
		
		ParcialCAMINOS p = new ParcialCAMINOS();
		
		ListaGenerica<Integer> l = p.resolver(catorce,3);
		
		l.comenzar();
		while(!(l.fin())) {
			System.out.println(l.proximo());
		}
}
}
