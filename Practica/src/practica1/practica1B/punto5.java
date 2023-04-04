package practica1.practica1B;


public class punto5 {
		
		private static int max = -1;
		private static int min = 99999;
		private static double prom = 0;
		private static int arregloEstatico[] = {1312,232,332,43213,125,36,74,81,9,310};
		
		public static int[] maxminA(int arreglo[]){
			int max = -1;
			int min = 99999;
			int sum = 0;
			for (int num:arreglo) {
				if(num > max) max = num;
				if(num < min) min = num;
				sum+=num;
			}
			int prom = sum/arreglo.length;
			int maxymin[] = {max,min,prom};
			return maxymin;
		}

		public static Maxymin maxminB(int arreglo[]){
			int max = -1;
			int min = 999999;
			int sum = 0;
			for (int num:arreglo) {
				if(num > max) max = num;
				if(num < min) min = num;
				sum+=num;	
			}
			Maxymin nums = new Maxymin();
			nums.setMax(max);
			nums.setMin(min);
			nums.setProm(sum/arreglo.length);
			return nums;
		}
		
		public static void maxminC() {
			int sum = 0;
			for (int num:arregloEstatico) {
				if(num > max) max = num;
				if(num < min) min = num;	
				sum+=num;
			}
			prom = sum/arregloEstatico.length;
		}
		
		public static void main(String[] args) {
			int arregloNoEstatico[] = {1312,232,332,43213,125,36,74,81,9,310};
			
			int maxymin[] = punto5.maxminA(arregloNoEstatico);
			System.out.println("max: "+maxymin[0]+" min: "+maxymin[1]+" promedio: "+maxymin[2]);
			
			Maxymin nums = punto5.maxminB(arregloNoEstatico);
			System.out.println("max: "+nums.getMax()+" min: "+nums.getMin()+" promedio: "+nums.getProm());
			
			punto5.maxminC();
			System.out.println("max: "+max+" min: "+min+" promedio: "+prom);
			
		}
}
