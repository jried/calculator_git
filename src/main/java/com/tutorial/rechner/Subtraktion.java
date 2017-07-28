package com.tutorial.rechner;

public class Subtraktion {
		private double a, b;
		
		protected Subtraktion(double a, double b) {
			this.a = a;
			this.b = b;
		}	
		
		public double sub() {
			return a - b;
		}
		
		protected void subtrahieren() {
			System.out.println("Ergebnis: " + sub());
		}

}