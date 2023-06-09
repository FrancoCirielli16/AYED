package tp03.ejercicio1;
import tp02.ejercicio3.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		if(this.esVacio()||this.esHoja()) {
			return 0;
		}
		return 1 + this.getHijoDerecho().contarHojas() + this.getHijoIzquierdo().contarHojas();
	}
	

    public ArbolBinario<T> espejo() {
    	
		ArbolBinario<T> espejo = new ArbolBinario<T>(this.getDato());
		
		if(this.tieneHijoDerecho()){
			espejo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
		}
		if(this.tieneHijoIzquierdo()) {
			espejo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
		}
		return espejo;
	}


	public void entreNiveles(int n, int m){
		ArbolBinario<T> arbol;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.apilar(this);
		cola.apilar(null);
		int nivel = 0;
		while((!cola.esVacia())&&(nivel<=m)){
			arbol = cola.desapilar();
			if(arbol!=null) {
				if(nivel>=n) 
					System.out.println(arbol.getDato());
				if(arbol.tieneHijoIzquierdo())
					cola.apilar(arbol.getHijoIzquierdo());
				if(arbol.tieneHijoDerecho())
					cola.apilar(arbol.getHijoDerecho());
			}
			else
				if(!cola.esVacia()) {
					cola.apilar(null);
					nivel++;
				}
		}
	}

}
