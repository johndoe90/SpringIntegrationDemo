package com.pf.calculator;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	public String calculate(String calculation) {
		try {
			String[] operands = calculation.split("(\\+)|(-)|(/)|(\\*)");	
			Double a = Double.parseDouble(operands[0]),
					b = Double.parseDouble(operands[1]);
			
			if (operands.length == 2) {
				if (calculation.contains("+")) { return a + " + " + b + " = " + (a + b); } 
				else if (calculation.contains("-")) { return a + " - " + b + " = " + (a - b); }
				else if (calculation.contains("/")) { return a + " / " + b + " = " + (a / b); }
				else if (calculation.contains("*")) { return a + " * " + b + " = " + (a * b); }
			}
			
			throw new Exception();
		} catch (Exception e) {
			return calculation + ": Fehler!";
		} 
	}
}
