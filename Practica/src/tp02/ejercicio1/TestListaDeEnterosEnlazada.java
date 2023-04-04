package tp02.ejercicio1;


public class TestListaDeEnterosEnlazada {

	public static void main(String[] args) {
		
		 ListaDeEnterosEnlazada listaEnlazada = new  ListaDeEnterosEnlazada();
		 
			for (int i=0; i<args.length; i++) {
				listaEnlazada.agregarFinal(Integer.parseInt(args[i]));
			}
			listaEnlazada.comenzar();
			for (int i=0; i<listaEnlazada.tamanio(); i++) {
				System.out.println(listaEnlazada.proximo());
			}
	}

}
