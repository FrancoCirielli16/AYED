package tp02.ejercicio4;

import java.util.Scanner;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio3.PilaGenerica;

public class TestBalanceo {
	
	public static boolean esBalanceado(String str) {
		ListaEnlazadaGenerica<Character> aperturas = new ListaEnlazadaGenerica<Character>();
		aperturas.agregarFinal('(');
		aperturas.agregarFinal('{');
		aperturas.agregarFinal('[');
		ListaEnlazadaGenerica<Character> cierres = new ListaEnlazadaGenerica<Character>();
		cierres.agregarFinal(')');
		cierres.agregarFinal('}');
		cierres.agregarFinal(']');
		PilaGenerica<Character> pila = new PilaGenerica<Character>();
		
		Character act,ant;
	
		for (int i=0; i<str.length(); i++){
			act = str.charAt(i);
			if(aperturas.incluye(act)) {
				pila.apilar(act);
			}
			else
				if(cierres.incluye(act)&& !(pila.esVacia())){
					ant = pila.desapilar();
					if(!((act.equals(')')||(act.equals('('))||(act.equals('['))||(act.equals(']'))||(act.equals('{'))||(act.equals('}')))))
						return false;
				}
				else
					return false;
		}
		if(!pila.esVacia()) {
			return false;
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese los caracteres ()[]{} en el orden que desee : ");
		String str = s.next();
		s.close();
  
        if (esBalanceado(str))
            System.out.println("Esta balanceada");
        else 
        	System.out.println("No esta balanceada" );
	}

}
