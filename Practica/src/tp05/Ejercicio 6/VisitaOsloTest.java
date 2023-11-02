package ejercicio6;

import ejercicio3.*;
import tp02.ejercicio2.*;

public class VisitaOsloTest {

	public static void main(String[] args) {
		Grafo<String> grafo = new GrafoImplListAdy<>();
		Vertice<String> v1 = new VerticeImplListAdy<String>("Ayuntamiento");
		Vertice<String> v2 = new VerticeImplListAdy<String>("Parque Botánico");
		Vertice<String> v3 = new VerticeImplListAdy<String>("Museo Munch");
		Vertice<String> v4 = new VerticeImplListAdy<String>("El Tigre");
		Vertice<String> v5 = new VerticeImplListAdy<String>("La Opera");
		Vertice<String> v6 = new VerticeImplListAdy<String>("Fortaleza Akershus");
		Vertice<String> v7 = new VerticeImplListAdy<String>("Akker Brigge");
		Vertice<String> v8 = new VerticeImplListAdy<String>("Palacio Real");
		Vertice<String> v9 = new VerticeImplListAdy<String>("Galería Nacional");
		Vertice<String> v10 = new VerticeImplListAdy<String>("Holmenkollen");
		Vertice<String> v11 = new VerticeImplListAdy<String>("Parque Vigeland");
		Vertice<String> v12 = new VerticeImplListAdy<String>("FolkMuseum");
		Vertice<String> v13 = new VerticeImplListAdy<String>("Museo Fram");
		Vertice<String> v14 = new VerticeImplListAdy<String>("Museo Vikingo");
		Vertice<String> v15 = new VerticeImplListAdy<String>("Museo del Barco Polar");

		grafo.agregarVertice(v1);
		grafo.agregarVertice(v2);
		grafo.agregarVertice(v3);
		grafo.agregarVertice(v4);
		grafo.agregarVertice(v5);
		grafo.agregarVertice(v6);
		grafo.agregarVertice(v7);
		grafo.agregarVertice(v8);
		grafo.agregarVertice(v9);
		grafo.agregarVertice(v10);
		grafo.agregarVertice(v11);
		grafo.agregarVertice(v12);
		grafo.agregarVertice(v13);
		grafo.agregarVertice(v14);
		grafo.agregarVertice(v15);

		grafo.conectar(v1, v2, 10);
		grafo.conectar(v1, v4, 15);
		grafo.conectar(v1, v7, 20);
		grafo.conectar(v1, v8, 5);
		grafo.conectar(v2, v1, 10);
		grafo.conectar(v2, v3, 1);
		grafo.conectar(v2, v9, 15);
		grafo.conectar(v3, v2, 1);
		grafo.conectar(v3, v4, 15);
		grafo.conectar(v4, v1, 15);
		grafo.conectar(v4, v3, 15);
		grafo.conectar(v4, v5, 5);
		grafo.conectar(v5, v4, 5);
		grafo.conectar(v5, v6, 10);
		grafo.conectar(v6, v5, 10);
		grafo.conectar(v7, v1, 20);
		grafo.conectar(v7, v12, 30);
		grafo.conectar(v7, v14, 30);
		grafo.conectar(v8, v1, 5);
		grafo.conectar(v8, v12, 5);
		grafo.conectar(v9, v2, 15);
		grafo.conectar(v9, v11, 10);
		grafo.conectar(v10, v11, 30);
		grafo.conectar(v11, v9, 10);
		grafo.conectar(v11, v10, 30);
		grafo.conectar(v11, v12, 20);
		grafo.conectar(v12, v7, 30);
		grafo.conectar(v12, v8, 5);
		grafo.conectar(v12, v11, 20);
		grafo.conectar(v12, v13, 5);
		grafo.conectar(v13, v12, 5);
		grafo.conectar(v13, v15, 5);
		grafo.conectar(v14, v7, 30);
		grafo.conectar(v14, v15, 5);
		grafo.conectar(v15, v13, 5);
		grafo.conectar(v15, v14, 5);

		ListaGenerica<String> lugaresRestringidos = new ListaEnlazadaGenerica<String>();
		lugaresRestringidos.agregarFinal("Palacio Real");
		lugaresRestringidos.agregarFinal("Galería Nacional");
		VisitaOslo o = new VisitaOslo();
		ListaGenerica<String> camino = o.paseoEnBici(grafo, "Museo del Barco Polar", 60, lugaresRestringidos);
		camino.comenzar();
		System.out.println("Camino desde Ayuntamiento a Museo del Barco Polar con un maximo de 60 minutos: " + camino);

		ListaGenerica<ListaGenerica<String>> caminos = o.paseosTiempo(grafo, 20);
		System.out.println("Caminos desde ayuntamiento que duran 20 minutos: ");
		caminos.comenzar();
		while (!caminos.fin())
			System.out.println(caminos.proximo());
	}

}
