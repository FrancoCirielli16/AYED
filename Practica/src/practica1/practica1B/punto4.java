package practica1.practica1B;


public class punto4 {
	
	public static void swap1 (int x, int y) {
		 if (x < y) {
			 int tmp = x ;
			 x = y ;
			 y = tmp;
		}
	}
	
	public static void swap2 (Integer x, Integer y) {
		if (x < y) {
			int tmp = x ;
			x = y ;
			y = tmp;
		 }
	}
	//No se esta retornado los valores al cambiar el valor de los parametros no cambiamos el valor de las variables de main se necesita retornar los valores 
	//lo mismo pasa con los primitivos no se cambia el valor del primitivo se necesita retornar el valor
	
	public static void main(String[] args) {
		int a = 1, b = 2;
		Integer c = 3, d = 4;
		swap1(a,b);
		swap2(c,d);
		System.out.println("a=" + a + " b=" + b) ;
		System.out.println("c=" + c + " d=" + d) ;
	}
}

