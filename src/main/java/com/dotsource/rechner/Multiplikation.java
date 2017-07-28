package com.dotsource.rechner;

public class Multiplikation {
		private double a, b;
		
		protected Multiplikation(double a, double b) {
			this.a = a;
			this.b = b;
		}	
		
		protected void multiplizieren() {
			double c;
			c = a * b;
			System.out.println("Ergebnis der Multiplikation: " + c);
		}

}