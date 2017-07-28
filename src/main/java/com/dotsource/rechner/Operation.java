package com.dotsource.rechner;

import java.util.regex.Pattern;

public class Operation {

	String operation;

	public Operation(String op) {
		operation = op;
	}

	public void run() {
		System.out.println("Ergebnis: " + execute());
	}
	
	Double execute(){
		double a = 0, c = 0, b = 0;
		char plus = '+', minus = '-';
		char x, y = operation.charAt(operation.length() - 3);
		String s;
		
		for(int i = 0; i < operation.length(); i = i + 2) {
			if(operation.charAt(i) != ' ' && operation.charAt(i) != plus && operation.charAt(i) != minus) {
				x = operation.charAt(i);
				s = Character.toString(x);
				a = Double.valueOf(s);
			}
			if(plus == operation.charAt(i)) {
				c = c + a;
			}
			else if(minus == operation.charAt(i)) {
				c = c - a;
			}
		}		
		switch(y) {
		case '+':
			b = c + a;
			break;
		case '-':
			b = c - a;
			break;
		default:
			b = c;
			break;
		}		
		return b;
		}
	}


