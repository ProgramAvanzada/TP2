package polinomios;

import java.util.Arrays;

class BinomioDeNewton {
	private double lineal;
	private double indepte;
	private int grado;
	private double []coeficientes;
	private int [] vecFactorial;
	private int ultimoFactorial;
	
	public BinomioDeNewton(double lineal, double indepte, int grado) {
		
		this.lineal = lineal;
		this.indepte = indepte;
		this.grado = grado;	
		this.vecFactorial = new int [20];
		this.vecFactorial[0] = 1;
		this.ultimoFactorial = 0;
		}
	
	public double obtenerCoeficiente(int k) {
		if (grado == 0)
			return 0;
		return calcularCoeficientes(k - 1);
	}

	private double calcularCoeficientes(int k) { /* C(N,K) *lin^K *indpte^k-n*/
		
		double combinatoria = this.factorial(grado)/((this.factorial(k)*this.factorial(this.grado-k)));
		double multiplicacionDeExp = Math.pow(this.lineal, this.grado - k) * Math.pow(this.indepte, k);
		return combinatoria * multiplicacionDeExp;
	}
	
	public int factorial(int n) {
        
		if(vecFactorial[n] != 0)
			return vecFactorial[n];
		
		if(n == 1){
			vecFactorial[n] = 1;
			return vecFactorial[n];
		}
		
		for (int i = ultimoFactorial + 1 ; i <= n; i++) {
			System.out.println("calculando factorial de " + i);
            vecFactorial[i] = vecFactorial[i-1] * i;
        }
		
		ultimoFactorial = n;
		return vecFactorial[n];
		
    }
	
	@Override
	public String toString() {
		return "BinomioDeNewton [lineal=" + lineal + ", indepte=" + indepte + ", grado=" + grado + ", coeficientes="
				+ Arrays.toString(coeficientes) + "]";
	}

	public void obtenerTodosLosCoeficientes(int k) {
		
		for(int i = 0; i < grado; i++) {
			
			this.coeficientes[i] = this.obtenerCoeficiente(k);
			k++;
		}
	}
	
	public double resolverBinomio(double valorX) {
		
		this.coeficientes = new double[grado +1];
		int k = 1;
		this.obtenerTodosLosCoeficientes(k);
		double resTotal = 0;
		if (grado == 0)
			return 1;
		for (int i = 0; i < coeficientes.length; i++) {
			
			resTotal += coeficientes[i] * (Math.pow(valorX, grado));
			grado--;
		}
			
		return resTotal;
	}
	
}
