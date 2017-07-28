package com.dotsource.rechner;

import java.util.Scanner;

public class Rechner {

	protected static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String x = "";
		choice(x);

	}

	protected static void choice(String x) {

		System.out.println("Rechenoperation (Eingabe): 'add', 'sub','mul','div', 'op':");
		x = scanner.next();

		switch (x) {
		case "add":
			add();
			break;
		case "sub":
			sub();
			break;
		case "mul":
			mul();
			break;
		case "div":
			div();
			break;
		case "op":
			operation();
			break;
		default:
			System.out.println("Fehlerhafte Eingabe");
			return;

		}
	}

	protected static void div() {

		System.out.println("Eingabe der beiden Zahlen: ");
		Division d1 = new Division(scanner.nextInt(), scanner.nextInt());
		d1.dividieren();

	}

	protected static void mul() {

		System.out.println("Eingabe der beiden Zahlen: ");
		Multiplikation m1 = new Multiplikation(scanner.nextInt(), scanner.nextInt());
		m1.multiplizieren();

	}

	protected static void sub() {

		System.out.println("Eingabe der beiden Zahlen: ");
		Subtraktion s1 = new Subtraktion(scanner.nextInt(), scanner.nextInt());
		s1.subtrahieren();

	}

	protected static void add() {

		System.out.println("Eingabe der beiden Zahlen: ");
		Addition a1 = new Addition(scanner.nextInt(), scanner.nextInt());
		a1.addieren();

	}

	protected static void operation() {

		System.out.println("Eingabe der Operation (z.B. 5 + 2): ");
		Operation o = new Operation(scanner.next());
		o.run();

	}

}
