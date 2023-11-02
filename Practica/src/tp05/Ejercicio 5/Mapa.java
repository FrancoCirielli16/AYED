package ejercicio5;

import ejercicio3.*;
import tp02.ejercicio2.*;

public class Mapa {
	private Grafo<String> mapaCiudades;

	public Mapa(Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}

	private Vertice<String> buscar(String ciudad1) {
		ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();
		listaVertices.comenzar();
		while (!listaVertices.fin()) {
			Vertice<String> v = listaVertices.proximo();
			if (v.dato().equals(ciudad1))
				return v;
		}
		return null;
	}

	private int[] buscarOrigenYDestino(String ciudad1, String ciudad2) {
		ListaGenerica<Vertice<String>> listaVertices = this.mapaCiudades.listaDeVertices();
		listaVertices.comenzar();
		int[] posiciones = { -1, -1 };
		boolean encontre = false;
		while (!listaVertices.fin() && !encontre) {
			Vertice<String> v = listaVertices.proximo();
			if (v.dato().equals(ciudad1))
				posiciones[0] = v.getPosicion();
			else if (v.dato().equals(ciudad2))
				posiciones[1] = v.getPosicion();
			if (posiciones[0] > 0 && posiciones[1] > 0)
				encontre = true;
		}
		return posiciones;
	}

	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();
		if (this.mapaCiudades == null || this.mapaCiudades.esVacio())
			return camino;
		int[] posiciones = buscarOrigenYDestino(ciudad1, ciudad2);
		if (posiciones[0] < 1 || posiciones[1] < 1)
			return camino;
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
		dfs(posiciones[0], marca, camino, ciudad2);
		return camino;
	}

	private boolean dfs(int i, boolean[] marca, ListaGenerica<String> camino, String ciudad2) {
		boolean encontre = false;
		marca[i] = true;
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i);
		camino.agregarFinal(v.dato());
		if (v.dato().equals(ciudad2))
			return true;
		ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin() && !encontre) {
			Arista<String> arista = ady.proximo();
			int j = arista.verticeDestino().getPosicion();
			if (!marca[j])
				encontre = dfs(j, marca, camino, ciudad2);
		}
		if (!encontre)
			camino.eliminarEn(camino.tamanio());
		return encontre;
	}

	private void marcarExceptuado(ListaGenerica<String> ciudades, boolean[] marca) {
		ciudades.comenzar();
		while (!ciudades.fin())
			marca[buscar(ciudades.proximo()).getPosicion()] = true;
	}

	public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,
			ListaGenerica<String> ciudades) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (this.mapaCiudades == null || this.mapaCiudades.esVacio())
			return camino;
		int[] posiciones = buscarOrigenYDestino(ciudad1, ciudad2);
		if (posiciones[0] < 1 || posiciones[1] < 1)
			return camino;
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
		marcarExceptuado(ciudades, marca);
		if (!marca[posiciones[0]] && !marca[posiciones[1]])
			dfs(posiciones[0], marca, camino, ciudad2);
		return camino;
	}

	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
		ListaGenerica<String> caminoResultante = new ListaEnlazadaGenerica<String>();
		if (this.mapaCiudades == null || this.mapaCiudades.esVacio())
			return caminoResultante;
		int[] posiciones = buscarOrigenYDestino(ciudad1, ciudad2);
		if (posiciones[0] < 1 || posiciones[1] < 1)
			return caminoResultante;
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
		dfsMasCorto(posiciones[0], marca, new ListaEnlazadaGenerica<String>(), caminoResultante, ciudad2, 0,
				Integer.MAX_VALUE);
		return caminoResultante;
	}

	private int dfsMasCorto(int i, boolean[] marca, ListaGenerica<String> caminoActual,
			ListaGenerica<String> caminoResultante, String ciudad2, int distancia, int minimo) {
		marca[i] = true;
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i);
		caminoActual.agregarFinal(v.dato());
		if (v.dato().equals(ciudad2) && distancia < minimo) {
			copiar(caminoActual, caminoResultante);
			minimo = distancia;
		} else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (minimo > distancia && !ady.fin()) {
				Arista<String> arista = ady.proximo();
				int j = arista.verticeDestino().getPosicion();
				if (!marca[j] && distancia + arista.peso() < minimo)
					minimo = dfsMasCorto(j, marca, caminoActual, caminoResultante, ciudad2, distancia + arista.peso(),
							minimo);
			}
		}
		caminoActual.eliminarEn(caminoActual.tamanio());
		marca[i] = false;
		return minimo;
	}

	private void copiar(ListaGenerica<String> caminoActual, ListaGenerica<String> caminoResultante) {
		caminoResultante.comenzar();
		while (!caminoResultante.fin())
			caminoResultante.eliminar(caminoResultante.proximo());
		caminoActual.comenzar();
		while (!caminoActual.fin())
			caminoResultante.agregarFinal(caminoActual.proximo());
	}

	public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (this.mapaCiudades == null || this.mapaCiudades.esVacio())
			return camino;
		int[] posiciones = buscarOrigenYDestino(ciudad1, ciudad2);
		if (posiciones[0] < 1 || posiciones[1] < 1)
			return camino;
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
		caminoSinCargarCombustible(posiciones[0], camino, marca, tanqueAuto, ciudad2);
		return camino;
	}

	private boolean caminoSinCargarCombustible(int i, ListaGenerica<String> camino, boolean[] marca, int tanqueAuto,
			String ciudad2) {
		boolean encontre = false;
		marca[i] = true;
		Vertice<String> v = this.mapaCiudades.listaDeVertices().elemento(i);
		camino.agregarFinal(v.dato());
		if (v.dato().equals(ciudad2))
			return true;
		ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
		ady.comenzar();
		while (!ady.fin() && !encontre) {
			Arista<String> arista = ady.proximo();
			int j = arista.verticeDestino().getPosicion();
			if (!marca[j] && tanqueAuto - arista.peso() >= 0)
				encontre = caminoSinCargarCombustible(j, camino, marca, tanqueAuto - arista.peso(), ciudad2);
		}
		if (!encontre)
			camino.eliminarEn(camino.tamanio());
		return encontre;
	}

	public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		if (this.mapaCiudades == null || this.mapaCiudades.esVacio())
			return camino;
		int[] posiciones = buscarOrigenYDestino(ciudad1, ciudad2);
		if (posiciones[0] < 1 || posiciones[1] < 1)
			return camino;
		boolean[] marca = new boolean[this.mapaCiudades.listaDeVertices().tamanio() + 1];
		caminoConMenorCargaDeCombustible(posiciones[0], ciudad2, new ListaEnlazadaGenerica<String>(), camino,
				tanqueAuto, tanqueAuto, 0, Integer.MAX_VALUE, marca);
		return camino;
	}

	private int caminoConMenorCargaDeCombustible(int i, String ciudad2, ListaGenerica<String> listaActual,
			ListaGenerica<String> listaResultante, int tanqueAuto, int tanqueActual, int recargas, int recargasMin,
			boolean[] marca) {
		marca[i] = true;
		Vertice<String> v = this.mapaCiudades.vertice(i);
		listaActual.agregarFinal(v.dato());
		if (v.dato().equals(ciudad2)) {
			recargasMin = recargas;
			copiar(listaActual, listaResultante);
		} else {
			ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(v);
			ady.comenzar();
			while (!ady.fin() && recargas < recargasMin) {
				Arista<String> a = ady.proximo();
				int j = a.verticeDestino().getPosicion();
				if (!marca[j]) {
					int peso = a.peso();
					if (tanqueActual - peso >= 0) // si me alcanza para ir con lo que tengo
						recargasMin = caminoConMenorCargaDeCombustible(j, ciudad2, listaActual, listaResultante,
								tanqueAuto, tanqueActual - peso, recargas, recargasMin, marca);
					else if (tanqueAuto - peso >= 0) // si el tanque lleno me alcanza para ir
						recargasMin = caminoConMenorCargaDeCombustible(j, ciudad2, listaActual, listaResultante,
								tanqueAuto, tanqueAuto - peso, recargas + 1, recargasMin, marca);
				}
			}
		}
		marca[i] = false;
		listaActual.eliminarEn(listaActual.tamanio());
		return recargasMin;
	}
}
