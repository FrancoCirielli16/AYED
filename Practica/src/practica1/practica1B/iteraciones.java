package practica1.practica1B;


public class iteraciones {
	
	public static void For(int a, int b) {
		for(int i=a; i<=b; i++) {
			System.out.print(i+" ");
		}
	}
	
	public static void While(int a,int b) {
		int i = a;
		while (i<=b) {
			System.out.print(i+" ");
			i++;
		}
	}
	
	public static void Recursivo1(int a,int b) {
		if(a<=b) {
			System.out.print(a+" ");
			Recursivo1(a+1, b);
		}
	}
	
		
	public static void Recursivo2(int a,int b) {
		 if (a == b) {
	            System.out.print(a+" ");
	        } else {
	            System.out.print(a+" ");
	            Recursivo2(a+1, b);
	        }
	}
	
	public static void Recursivo3(int a,int b) {
		int i = a;
		if(i<=b) {
			System.out.print(i+" ");
			Recursivo1(i+1, b);
		}
	}
	
	
}
