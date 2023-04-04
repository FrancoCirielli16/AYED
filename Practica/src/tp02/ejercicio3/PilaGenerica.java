package tp02.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;


public class PilaGenerica<T>{
	
	private ListaGenerica<T> Pila= new ListaEnlazadaGenerica<T>();
	
	
	
	public void apilar(T elem) {
		this.Pila.agregarInicio(elem);
	}
	
	public T desapilar(){
		T temp = this.Pila.elemento(1);
		this.Pila.eliminarEn(1);
		return temp;
	}
	
	public T tope() {
		return this.Pila.elemento(1);
	}
	
	public boolean esVacia() {
		return this.Pila.tamanio()==0;
	}

	
	
}
