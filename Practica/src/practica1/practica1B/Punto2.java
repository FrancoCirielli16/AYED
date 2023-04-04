package practica1.practica1B;

import java.util.Scanner;

public class Punto2 {
	
	public static int[] crearArreglo(int n) {
		int arreglo[] = new int[n];
		int i = 0;
		int num = 0;
		for (i=0;i<n;i++) {
			arreglo[i] = n + num;
			num += n;
		}
		return arreglo;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in) ;
		System.out.print("Ingrese el numero del vector que quieres crear:");
		int n = s.nextInt();
		int arreglo[] = crearArreglo(n);
		for (int i=0; i<n; i++) {
			System.out.print(arreglo[i]+" ");
		}
		
	}
}
