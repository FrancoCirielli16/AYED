package tp02.ejercicio1;



public class Ejercicio1_6 {
	
//	public ListaDeEnterosEnlazada calcularSucesion (int n) {
//	
//		ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
//		
//		if (n == 1) {
//			l.agregarFinal(n);
//			return l;
//		}
//
//		if (n%2==0) {
//			calcularSucesion(n/2);
//		}
//		else {
//			calcularSucesion(3*n+1);
//		}
//	
//		return l;
//	}
	
	public static void main (String[] args) {
		 Ejercicio1_6 f = new Ejercicio1_6();
		 ListaDeEnterosEnlazada l = f. calcularSucesion2(69);
		 
		 l.comenzar();
		 while(!l.fin()) {
			 System.out.println(l.proximo());
		 }
	}

	public ListaDeEnterosEnlazada calcularSucesion2 (int n) {
		if (n <= 1) {
			ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
			l.agregarInicio(n);
			return l;
		}
		
		int parametro;
		
		if (n%2==0) {
		    parametro = n/2;	
		}
		else {
			parametro = 3*n+1;
		}
		
		ListaDeEnterosEnlazada temporal = calcularSucesion2(parametro);
		temporal.agregarInicio(n);
		return temporal;
	}
}
