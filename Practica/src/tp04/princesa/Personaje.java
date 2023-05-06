package tp04.princesa;

public class Personaje {
	private String personaje;
	
	public boolean esPrincesa() {
		return this.personaje.equals("princesa");
	}
	
	
	public boolean esDragon() {
		return this.personaje.equals("dragon");
	}
	

}
