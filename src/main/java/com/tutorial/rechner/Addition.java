package com.tutorial.rechner;

public class Addition {
		private double a, b;
		
		protected Addition(double a, double b) {
			this.a = a;
			this.b = b;
		}	
		
		protected void addieren() {
			System.out.println("Ergebnis der Addition: " + add());
		}
		
		protected double add() {
			return a + b;
		}


}

	