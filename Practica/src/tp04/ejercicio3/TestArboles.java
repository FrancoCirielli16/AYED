package tp04.ejercicio3;

import tp02.ejercicio2.*;
import tp04.ejercicio1.ArbolGeneral;


public class TestArboles {
	public static void main(String[] args) {
			
		
		
			ListaGenerica<ArbolGeneral<Integer>> lista = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
			
			
			
			
			ArbolGeneral<Integer> c = new ArbolGeneral<Integer>(3);
			ArbolGeneral<Integer> d = new ArbolGeneral<Integer>(4);
			ArbolGeneral<Integer> e = new ArbolGeneral<Integer>(5);
			ArbolGeneral<Integer> f = new ArbolGeneral<Integer>(6);
			ArbolGeneral<Integer> g = new ArbolGeneral<Integer>(7);
			ArbolGeneral<Integer> h = new ArbolGeneral<Integer>(8);
			ArbolGeneral<Integer> i = new ArbolGeneral<Integer>(9);
			ArbolGeneral<Integer> j = new ArbolGeneral<Integer>(10);
			
			f.agregarHijo(h);		
			f.agregarHijo(i);
			
			// 	   6
			//	 /	 \
			//  8     9
			
			g.agregarHijo(j);
				
			//    7
			//   /
			//  10
				
			lista.agregarFinal(c);
			lista.agregarFinal(d);
			lista.agregarFinal(e);
			
			ArbolGeneral<Integer> b = new ArbolGeneral<Integer>(13,lista);
			
			//	    13
			//	  / /  \ 
			//	3  4   5
			
			lista = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
			
			lista.agregarFinal(b);
			lista.agregarFinal(f);
			lista.agregarFinal(g);
			
			ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(11,lista);
			
				//		    raiz 11
				//        /  \	     \
				//       /    \	      \
				//	    /      \       \ 
				//	   b        f       g
				// 	 / / \	  /   \     /
				//  3 4  5   8      9  10
			
			RecorridosAG recorridos = new RecorridosAG();
			
			ListaGenerica <Integer> listaDatos = recorridos.numerosImparesMayoresQuePreOrden(a,6);
			
			System.out.println("PREORDEN: " + listaDatos);
			
			listaDatos = recorridos.numerosImparesMayoresQueInOrden(a,6);
			 
			System.out.println("INORDEN: "+ listaDatos);
			
			listaDatos = recorridos.numerosImparesMayoresQuePostOrden(a,6);
			
			System.out.println("POSTORDEN: "+ listaDatos);
			
			listaDatos = recorridos.numerosImparesMayoresQuePorNiveles(a,6);
			
			System.out.println("POR NIVELES: "+ listaDatos);
			
			ArbolGeneralINT arbol = new ArbolGeneralINT(a);
			
			ListaGenerica <Integer> listaDatos2 = arbol.numerosImparesMayoresQuePreOrden(6);
			
			System.out.println("PREORDEN: " + listaDatos2);
			
			listaDatos2 = arbol.numerosImparesMayoresQueInOrden(6);
			 
			System.out.println("INORDEN: "+ listaDatos2);
			
			listaDatos2 = arbol.numerosImparesMayoresQuePostOrden(6);
			
			System.out.println("POSTORDEN: "+ listaDatos2);
			
			listaDatos2 = arbol.numerosImparesMayoresQuePorNiveles(6);
			
			System.out.println("POR NIVELES: "+ listaDatos2);
			
			
		
		
		}
		
		
		

}

