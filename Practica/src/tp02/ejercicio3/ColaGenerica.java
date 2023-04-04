package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ColaGenerica<T> {
	
	private ListaGenerica<T> Cola = new ListaEnlazadaGenerica<T>();
	

	public void apilar(T elem) {
		this.Cola.agregarFinal(elem);
	}
	
	public T desapilar(){
		T temp = this.Cola.elemento(1);
		this.Cola.eliminarEn(1);
		return temp;
	}
	
	public T tope() {
		return this.Cola.elemento(1);
	}
	
	public boolean esVacia() {
		return this.Cola.tamanio()==0;
	}
	
}
