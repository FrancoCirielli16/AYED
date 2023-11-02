package ejercicio6;

import ejercicio3.*;
import tp02.ejercicio2.*;

public class VisitaOslo {

	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo,
			ListaGenerica<String> lugaresRestringidos) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (lugares == null || lugares.esVacio())
			return camino;
		int[] posiciones = buscarOrigenYDestino(lugares.listaDeVertices(), "Ayuntamiento", destino);
		if (posiciones[0] < 1 && posiciones[1] < 1)
			return camino;
		boolean[] marca = new boolean[lugares.listaDeVertices().tamanio() + 1];
		marcarExceptuado(lugaresRestringidos, marca, lugares.listaDeVertices());
		if (!marca[posiciones[0]] && !marca[posiciones[1]])
			dfs(posiciones[0], marca, destino, lugares, camino, maxTiempo);
		return camino;
	}

	private void marcarExceptuado(ListaGenerica<String> prohibidos, boolean[] marca,
			ListaGenerica<Vertice<String>> vertices) {
		prohibidos.comenzar();
		while (!prohibidos.fin())
			marca[buscar(prohibidos.proximo(), vertices).getPosicion()] = true;
	}

	private int[] buscarOrigenYDestino(ListaGenerica<Vertice<String>> listaVertices, String origen, String destino) {
		int[] posiciones = { -1, -1 };
		listaVertices.comenzar();
		boolean encontre = false;
		while (!listaVertices.fin() && !encontre) {
			Vertice<String> v = listaVertices.proximo();
			if (v.dato().equals(origen))
				posiciones[0] = v.getPosicion();
			else if (v.dato().equals(destino))
				posiciones[1] = v.getPosicion();
			if (posiciones[0] > 0 && posiciones[1] > 0)
				encontre = true;
		}
		return posiciones;
	}

	private Vertice<String> buscar(String lugar, ListaGenerica<Vertice<String>> vertices) {
		vertices.comenzar();
		while (!vertices.fin()) {
			Vertice<String> v = vertices.proximo();
			if (v.dato().equals(lugar))
				return v;
		}
		return null;
	}

	private boolean dfs(int i, boolean[] marca, String destino, Grafo<String> grafo, ListaGenerica<String> camino,
			int tiempo) {
		marca[i] = true;
		boolean encontre = false;
		Vertice<String> v = grafo.listaDeVertices().elemento(i);
		camino.agregarFinal(v.dato());
		if (v.dato().equals(destino))
			return true;
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin() && !encontre) {
			Arista<String> a = ady.proximo();
			int j = a.verticeDestino().getPosicion();
			if (!marca[j] && tiempo - a.peso() >= 0)
				encontre = dfs(j, marca, destino, grafo, camino, tiempo - a.peso());
		}
		if (!encontre)
			camino.eliminarEn(camino.tamanio());
		return encontre;
	}

	public ListaGenerica<ListaGenerica<String>> paseosTiempo(Grafo<String> grafo, int tiempo) {
		ListaGenerica<ListaGenerica<String>> caminos = new ListaEnlazadaGenerica<ListaGenerica<String>>();
		if (grafo == null || grafo.esVacio())
			return caminos;
		Vertice<String> v = buscar("Ayuntamiento", grafo.listaDeVertices());
		if (v == null)
			return caminos;
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		dfsTiempo(v.getPosicion(), marca, grafo, tiempo, new ListaEnlazadaGenerica<String>(), caminos);
		return caminos;
	}

	private void dfsTiempo(int i, boolean[] marca, Grafo<String> grafo, int tiempo, ListaGenerica<String> caminoActual,
			ListaGenerica<ListaGenerica<String>> caminos) {
		marca[i] = true;
		Vertice<String> v = grafo.listaDeVertices().elemento(i);
		caminoActual.agregarFinal(v.dato());
		if (tiempo == 0) {
			caminos.agregarFinal(caminoActual.clonar());
		} else {
			ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin()) {
				Arista<String> a = ady.proximo();
				int j = a.verticeDestino().getPosicion();
				if (!marca[j] && tiempo - a.peso() >= 0)
					dfsTiempo(j, marca, grafo, tiempo - a.peso(), caminoActual, caminos);
			}
		}
		marca[i] = false;
		caminoActual.eliminarEn(caminoActual.tamanio());
	}

}
