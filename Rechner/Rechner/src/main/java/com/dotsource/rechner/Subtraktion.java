package com.dotsource.rechner;

public class Subtraktion {
		private double a, b;
		
		protected Subtraktion(double a, double b) {
			this.a = a;
			this.b = b;
		}	
		
		protected void subtrahieren() {
			double c;
			c = a - b;
			System.out.println("Ergebnis der Subtraktion: " + c);
		}

}