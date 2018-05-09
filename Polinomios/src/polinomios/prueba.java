package polinomios;

public class prueba {

	public static void main(String[] args) {
		
		double [] vector = {1,3,2};
		
		Polinomios polinomio = new Polinomios(2,vector);
		
		System.out.println(polinomio.evaluarHorner(0));
		
		BinomioDeNewton n = new BinomioDeNewton(0, 0, 0);
		
		System.out.println(n.factorial(5));
		System.out.println(n.factorial(6));
		System.out.println(n.factorial(7));
		System.out.println(n.factorial(3));
		System.out.println(n.factorial(10));
		System.out.println(n.factorial(4));
		

	}

}
