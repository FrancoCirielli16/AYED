package ejercicio4;

import ejercicio3.*;
import tp02.ejercicio2.ListaGenerica;

public class RecorridosTest {
	public static void main(String[] args) {
		Vertice<String> v1 = new VerticeImplListAdy<String>("La Plata");
		Vertice<String> v2 = new VerticeImplListAdy<String>("City Bell");
		Vertice<String> v3 = new VerticeImplListAdy<String>("Gonnet");
		Vertice<String> v4 = new VerticeImplListAdy<String>("Ringuelet");
		Vertice<String> v5 = new VerticeImplListAdy<String>("Tolosa");

		Grafo<String> grafoCiudades = new GrafoImplListAdy<String>();
		grafoCiudades.agregarVertice(v1);
		grafoCiudades.agregarVertice(v2);
		grafoCiudades.agregarVertice(v3);
		grafoCiudades.agregarVertice(v4);
		grafoCiudades.agregarVertice(v5);

		grafoCiudades.conectar(v2, v5);
		grafoCiudades.conectar(v5, v2);
		grafoCiudades.conectar(v2, v3);
		grafoCiudades.conectar(v3, v2);
		grafoCiudades.conectar(v3, v1);
		grafoCiudades.conectar(v1, v3);
		grafoCiudades.conectar(v3, v5);
		grafoCiudades.conectar(v5, v3);
		grafoCiudades.conectar(v4, v5);
		grafoCiudades.conectar(v5, v4);
		grafoCiudades.conectar(v4, v1);
		grafoCiudades.conectar(v1, v4);
		grafoCiudades.conectar(v5, v1);
		grafoCiudades.conectar(v1, v5);

		Recorridos<String> r = new Recorridos<>();
		System.out.println("Se imprime el grafo con DFS: ");
		ListaGenerica<Vertice<String>> listaDFS = r.dfs(grafoCiudades);
		listaDFS.comenzar();
		while (!listaDFS.fin())
			System.out.println(listaDFS.proximo().dato());

		System.out.println("Se imprime el grafo con BFS: ");
		ListaGenerica<Vertice<String>> listaBFS = r.bfs(grafoCiudades);
		listaBFS.comenzar();
		while (!listaBFS.fin())
			System.out.println(listaBFS.proximo().dato());
	}
}
