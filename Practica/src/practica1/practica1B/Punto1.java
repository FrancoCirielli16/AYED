package practica1.practica1B;


public class Punto1 {

	public static void main(String[] args) {
		int a = 1;
		int b = 10;
		System.out.println("Imprimir con for:");
		iteraciones.For(a, b);
		System.out.println("");
		System.out.println("Imprimir con while:");
		iteraciones.While(a, b);
		System.out.println("");
		System.out.println("Imprimir con recursion 1:");
		iteraciones.Recursivo1(a, b);
		System.out.println("");
		System.out.println("Imprimir con recursion 2:");
		iteraciones.Recursivo2(a, b);
		System.out.println("");
		System.out.println("Imprimir con recursion 3:");
		iteraciones.Recursivo3(a, b);
	}

}
