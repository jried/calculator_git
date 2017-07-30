package com.tutorial.rechner;

public class Multiplikation {
		private double a, b;
		
		protected Multiplikation(double a, double b) {
			this.a = a;
			this.b = b;
		}	
		
		public void multiplizieren(){
			System.out.println("Ergebnis: " + mul());
		}
		
		protected double mul() {
			return a + b;
		}

}