// CS201 Exam 3 Fall 2021

import java.util.Map;

public class Q2 {
	public static Double orderTotal(Map<String, Double> prices, Map<String, Integer> order) {
		double totalCost = 0;
		for (String key : order.keySet()) {
			totalCost += order.get(key)*prices.get(key);
		}
		return totalCost;
	}
}
