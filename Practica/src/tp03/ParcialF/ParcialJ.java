package tp03.ParcialF;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ParcialJ {

    public ListaGenerica<ArbolBinario<Integer>> buscando(ArbolBinario<Integer> arbol, Integer a, Integer b) {
        ListaGenerica<ArbolBinario<Integer>> camino = new ListaEnlazadaGenerica<ArbolBinario<Integer>>();
        if (!arbol.esVacio()) {
            ArbolBinario<Integer> aux = buscarPrimerNodo(arbol, a);
            if (aux != null)
                buscarCamino(aux, b, camino);
        }
        return camino;
    }

    private ArbolBinario<Integer> buscarPrimerNodo(ArbolBinario<Integer> arbol, Integer a) {
        ArbolBinario<Integer> aux = null;
        if (arbol.getDato() == a)
            return arbol;
        if (arbol.tieneHijoIzquierdo())
            aux = buscarPrimerNodo(arbol.getHijoIzquierdo(), a);
        if (aux != null && arbol.tieneHijoDerecho())
            aux = buscarPrimerNodo(arbol.getHijoDerecho(), a);
        return aux;
    }

    private boolean buscarCamino(ArbolBinario<Integer> arbol, Integer b, ListaGenerica<ArbolBinario<Integer>> lista) {
        boolean ok = false;
        lista.agregarFinal(arbol);
        if (arbol.getDato() == b)
            return true;
        if (arbol.tieneHijoIzquierdo())
            ok = buscarCamino(arbol.getHijoIzquierdo(), b, lista);
        if (!ok && arbol.tieneHijoIzquierdo())
            ok = buscarCamino(arbol.getHijoDerecho(), b, lista);
        if (!ok)
            lista.eliminarEn(lista.tamanio());
        return ok;
    }
}
