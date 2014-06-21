package com.pf.calculator;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CalculationsSplitter {
	public List<String> split(String calculations) {
		return Arrays.asList(calculations.split(","));
	}
}
