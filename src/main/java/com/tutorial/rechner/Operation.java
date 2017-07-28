package com.tutorial.rechner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {

	final String MINUS = " - ";
	final String PLUS = " + ";
	final String MUL = " * ";
	final String DIV = " / ";

	final char MINUSwithoutSpaces = '-';
	final char PLUSwithoutSpaces = '+';
	final char MULwithoutSpaces = '*';
	final char DIVwithoutSpaces = '/';

	String operation;

	public Operation(String op) {
		operation = op;
	}

	public void run() {
		System.out.println("Ergebnis: " + execute());
	}

	Double execute() {

		operation = findBraces(operation);
		operation = executeOperations(operation, MUL);
		operation = executeOperations(operation, DIV);
		operation = executeOperations(operation, MINUS);
		operation = executeOperations(operation, PLUS);

		return Double.parseDouble(operation);
	}

	private String executeOperations(final String operation, final String operand) {

		String operationPart = operation;
		int indexOfOperation = operationPart.indexOf(operand) + 1;

		while (operationPart.contains(operand)) {

			double calculateResult = 0;

			String leftOperandString = getLeftOperand(operationPart, indexOfOperation, operand);
			String rightOperandString = getRightOperand(operationPart, indexOfOperation);

			double leftOperand = Double.parseDouble(leftOperandString);
			double rightOperand = Double.parseDouble(rightOperandString);

			switch (operand) {
			case MUL:
				calculateResult = new Multiplikation(leftOperand, rightOperand).mul();
				break;
			case DIV:
				calculateResult = new Division(leftOperand, rightOperand).divide();
				break;
			case PLUS:
				calculateResult = new Addition(leftOperand, rightOperand).add();
				break;
			case MINUS:
				calculateResult = new Subtraktion(leftOperand, rightOperand).sub();
				break;
			case "-":
				calculateResult = new Subtraktion(leftOperand, rightOperand).sub();
				break;
			default:
				throw new IllegalArgumentException("Division durch 0 nicht möglich.");
			}
			String substring = leftOperandString + operand + rightOperandString;

			operationPart = operationPart.replace(substring, "" + calculateResult);
		}
		return operationPart;
	}

	public String getRightOperand(String operationPart, int indexOfOperation) {
		int rightBorder = operationPart.length();
		
		String sub = operationPart.substring(indexOfOperation, rightBorder);
		
		String a = sub.replaceFirst("[\\s]*[\\S][\\s]*", "");
		String b = a.replaceAll("[\\s][+*\\/-][\\s]?[0-9]*[.]?[0-9]*", "");

		if (b.contains("-") && b.indexOf('-') != 0) {
			b = b.replaceAll("[\\s]*?[-][\\S]*", "");
		}

		String rightOperandString = b;
		return rightOperandString;
	}

	public String getLeftOperand(String operationPart, int indexOfOperation, final String operand) {
		int leftBorder = 0;

		if (MUL.equals(operand) || DIV.equals(operand) || MINUS.equals(operand)) {
			String substringSearchOperation = operationPart.substring(0, indexOfOperation);

			int length = substringSearchOperation.length() - 2;

			while (length > 0) {
				char c = substringSearchOperation.charAt(length);

				if (c == PLUSwithoutSpaces || c == MINUSwithoutSpaces || c == MULwithoutSpaces
						|| c == DIVwithoutSpaces) {
					break;
				}
				length--;
			}
			leftBorder = length;
		}

		String sub = operationPart.substring(leftBorder, indexOfOperation);

		String a = sub.replaceFirst("[*\\/+\\s]*", "");
		String leftOperandString = a.replaceAll("[\\s]?[\\s][\\\\-]?", "");

		return leftOperandString;

	}

	public String findBraces(final String operation) {
		String operationPart = operation;
		String braceOperation = operationPart;
		while (braceOperation.contains("(") && braceOperation.contains(")")) {
			String newTest = replaceInternalcontentOfBraces(braceOperation);
			if (braceOperation.equals(newTest)) {
				break;
			}
			braceOperation = newTest;
		}
		return braceOperation;
	}

	private String replaceInternalcontentOfBraces(String braceOperation) {
		String bracersRegex = "\\(([\\w-+\\/*.\\s]*)\\)";
		Pattern p = Pattern.compile(bracersRegex);
		Matcher m = p.matcher(braceOperation);
		if (m.find()) {
			String contentOfBraces = m.group();
			String braces = contentOfBraces;

			contentOfBraces = contentOfBraces.replaceFirst("[(]", "");
			contentOfBraces = contentOfBraces.replaceFirst("[)]", "");

			while (contentOfBraces.contains(MUL)) {
				contentOfBraces = executeOperations(contentOfBraces, MUL);
			}
			while (contentOfBraces.contains(DIV)) {
				contentOfBraces = executeOperations(contentOfBraces, DIV);
			}
			while (contentOfBraces.contains(MINUS)) {
				contentOfBraces = executeOperations(contentOfBraces, MINUS);
			}
			while (contentOfBraces.contains(PLUS)) {
				contentOfBraces = executeOperations(contentOfBraces, PLUS);
			}
			braceOperation = braceOperation.replace(braces, contentOfBraces);
			return braceOperation;
		} else {
			return braceOperation;
		}
	}
}