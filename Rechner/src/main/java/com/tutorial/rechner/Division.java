package com.tutorial.rechner;

public class Division {
		private double a,b;
		
		Division(double a, double b) {
			this.a = a;
			this.b = b;
		}	
		
		void dividieren() {
			
			try
			{
				double c = divide();
				System.out.println("Ergebnis der Division: " + c);
			}
			catch(IllegalArgumentException e)
			{
				System.out.println(e.getMessage());
			}
			
		}		
		double divide()
		{
			double c;
			if(b == 0) {
				throw new IllegalArgumentException("Division durch 0 nicht möglich.");
			}
			
			else {			
				c = a / b;
				return c;
			}
		}		
}
