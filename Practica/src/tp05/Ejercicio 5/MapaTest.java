package ejercicio5;

import ejercicio3.*;
import tp02.ejercicio2.*;

public class MapaTest {
	public static void main(String[] args) {
		Grafo<String> grafoCiudades = new GrafoImplListAdy<String>();
		Vertice<String> v1 = new VerticeImplListAdy<String>("La Plata");
		Vertice<String> v2 = new VerticeImplListAdy<String>("City Bell");
		Vertice<String> v3 = new VerticeImplListAdy<String>("Gonnet");
		Vertice<String> v4 = new VerticeImplListAdy<String>("Ringuelet");
		Vertice<String> v5 = new VerticeImplListAdy<String>("Tolosa");
		Vertice<String> v6 = new VerticeImplListAdy<String>("Villa Elisa");
		Vertice<String> v7 = new VerticeImplListAdy<String>("Los Hornos");

		grafoCiudades.agregarVertice(v1);
		grafoCiudades.agregarVertice(v2);
		grafoCiudades.agregarVertice(v3);
		grafoCiudades.agregarVertice(v4);
		grafoCiudades.agregarVertice(v5);
		grafoCiudades.agregarVertice(v6);
		grafoCiudades.agregarVertice(v7);

		grafoCiudades.conectar(v1, v3, 10);
		grafoCiudades.conectar(v1, v4, 15);
		grafoCiudades.conectar(v1, v5, 20);
		grafoCiudades.conectar(v1, v7, 18);
		grafoCiudades.conectar(v2, v3, 24);
		grafoCiudades.conectar(v2, v6, 11);
		grafoCiudades.conectar(v2, v5, 9);
		grafoCiudades.conectar(v3, v2, 24);
		grafoCiudades.conectar(v3, v1, 10);
		grafoCiudades.conectar(v3, v5, 12);
		grafoCiudades.conectar(v4, v5, 16);
		grafoCiudades.conectar(v4, v1, 15);
		grafoCiudades.conectar(v5, v2, 9);
		grafoCiudades.conectar(v5, v3, 12);
		grafoCiudades.conectar(v5, v4, 16);
		grafoCiudades.conectar(v5, v1, 20);
		grafoCiudades.conectar(v6, v2, 11);
		grafoCiudades.conectar(v6, v7, 8);
		grafoCiudades.conectar(v7, v1, 18);
		grafoCiudades.conectar(v7, v6, 8);

		Mapa m = new Mapa(grafoCiudades);

		ListaGenerica<String> camino = m.devolverCamino("City Bell", "La Plata");
		camino.comenzar();
		System.out.println("Metodo devolverCamino: " + camino);

		ListaGenerica<String> exceptuando = new ListaEnlazadaGenerica<String>();
		exceptuando.agregarFinal("Gonnet");
		exceptuando.agregarFinal("Ringuelet");
		exceptuando.agregarFinal("Villa Elisa");
		exceptuando.agregarFinal("City Bell");
		ListaGenerica<String> caminoExceptuando = m.devolverCaminoExceptuando("City Bell", "Los Hornos", exceptuando);
		caminoExceptuando.comenzar();
		System.out.println("Metodo devolverCaminoExceptuando: " + caminoExceptuando);

		ListaGenerica<String> caminoMasCorto = m.caminoMasCorto("Villa Elisa", "Ringuelet");
		caminoMasCorto.comenzar();
		System.out.println("Metodo caminoMasCorto: " + caminoMasCorto);

		ListaGenerica<String> caminoSinCargar = m.caminoSinCargarCombustible("La Plata", "Los Hornos", 50);
		caminoSinCargar.comenzar();
		System.out.println("Metodo caminoSinCargar: " + caminoSinCargar);

		ListaGenerica<String> caminoMenorCarga = m.caminoConMenorCargaDeCombustible("VHASCOMUS", "La Plata", 15);
		caminoMenorCarga.comenzar();
		System.out.println("Metodo caminoMenorCarga: " + caminoMenorCarga);
	}
}
