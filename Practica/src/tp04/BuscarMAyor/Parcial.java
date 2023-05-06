package tp04.BuscarMAyor;

import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Parcial {
	public Integer buscarMayor(ArbolGeneral<Integer> a) {
		Integer max = 0;
		if (!a.esHoja()) {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				max = Math.max(max, buscarMayor(hijos.proximo()));
			}
			if (a.getDato() > max)
				max = a.getDato();
			return max;
		}
		return a.getDato();
	}
}
