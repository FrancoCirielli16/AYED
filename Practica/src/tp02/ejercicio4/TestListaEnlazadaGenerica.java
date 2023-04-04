package tp02.ejercicio4;
import tp02.ejercicio2.*;

public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		Estudiante E1 = new Estudiante("Franco","Cirielli","comision 1","nose@gmail.com","1 y 49");
		Estudiante E2 = new Estudiante("Franco","Cirielli","comision 1","nose@gmail.com","1 y 49");
		Estudiante E3 = new Estudiante("Franco","Cirielli","comision 1","nose@gmail.com","1 y 49");
		Estudiante E4 = new Estudiante("Franco","Cirielli","comision 1","nose@gmail.com","1 y 49");
		
//		ListaEnlazadaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<Estudiante>();
//		lista.agregarFinal(E1);
//		lista.agregarFinal(E2);
//		lista.agregarFinal(E3);
//		lista.agregarFinal(E4);
//		lista.comenzar();
//		while(!lista.fin()) {
//			System.out.println(lista.proximo().tusDatos());
//		}
		
		Estudiante[]arreglo = new Estudiante[4];
		arreglo[0]=E1;
		arreglo[1]=E2;
		arreglo[2]=E3;
		arreglo[3]=E4;
		ListaEnlazadaGenerica<Estudiante> lista2 = new ListaEnlazadaGenerica<Estudiante>();
		lista2.agregar(arreglo);
		lista2.comenzar();
		while(!lista2.fin()) {
			System.out.println(lista2.proximo().tusDatos());
		}
	}

}
