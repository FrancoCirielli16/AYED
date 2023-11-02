package ejercicio4;

import ejercicio3.*;
import practica2.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class Recorridos<T> {

	public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo) {
		ListaGenerica<Vertice<T>> listaVertices = new ListaEnlazadaGenerica<Vertice<T>>();
		if (grafo == null || grafo.esVacio())
			return listaVertices;
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		dfs(1, grafo, marca, listaVertices);
		return listaVertices;
	}

	private void dfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> listaVertices) {
		marca[i] = true;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		listaVertices.agregarFinal(v);
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin()) {
			int j = ady.proximo().verticeDestino().getPosicion();
			if (!marca[j])
				dfs(j, grafo, marca, listaVertices);
		}
	}

	public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo) {
		ListaGenerica<Vertice<T>> listaVertices = new ListaEnlazadaGenerica<Vertice<T>>();
		if (grafo == null || grafo.esVacio())
			return listaVertices;
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		bfs(1, grafo, marca, listaVertices);
		return listaVertices;
	}

	private void bfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> listaVertices) {
		ListaGenerica<Arista<T>> ady = null;
		ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
		q.encolar(grafo.listaDeVertices().elemento(i));
		marca[i] = true;
		while (!q.esVacia()) {
			Vertice<T> v = q.desencolar();
			listaVertices.agregarFinal(v);
			ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<T> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j]) {
					Vertice<T> w = arista.verticeDestino();
					marca[j] = true;
					q.encolar(w);
				}
			}
		}
	}

}
