package practica1.practica1B.punto3;

public class Test {

	public static void main(String[] args) {
		
		//Estudiantes:
		Estudiante estudiantes[] = new Estudiante[2];
		Estudiante E = new Estudiante();
		E.setNombre("Franco");
		E.setApellido("Cirielli");
		E.setComision("Comision 1");
		E.setEmail("CirielliFrancoGiovanni@gmail.com");
		E.setDireccion("1 y 47");
		estudiantes[0]=E;
		E.setNombre("Flor");
		E.setApellido("Cirielli");
		E.setComision("Comision 2");
		E.setEmail("CirielliFlorGiovanni@gmail.com");
		E.setDireccion("1 y 49");
		estudiantes[1]=E;
		
		for(int i=0;i<2;i++) {
			System.out.println(estudiantes[i].tusDatos());
		}
		
		//Profesores:
		Profesor profesores[] = new Profesor[3];
		Profesor P = new Profesor();
		P.setNombre("Nose");
		P.setApellido("Nose");
		P.setEmail("Nose");
		P.setFacultad("INFO");
		P.setCatedra("INFO");
		profesores[0] = P;
		profesores[1] = P;
		profesores[2] = P;
		
		for(int i=0;i<3;i++) {
			System.out.println(profesores[i].tusDatos());
		}
		
	}

}
