package com.pf.calculator;

import java.util.Collection;

import org.springframework.stereotype.Component;

@Component
public class CalculationsAggregator {
	public String aggregate(Collection<String> calculations) {
		String result = "";
		for (String calculation : calculations) {
			result += calculation + ",\n";
		}
		
		return result.substring(0, result.length() - 2);
	}
}
