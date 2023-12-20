package a_Introductory;

public class Fibonacci {

	// Method to calculate the nth Fibonacci number
	public int fib(int n) {
		// Base case: if n is 0, return 0
		if (n == 0) {
			return 0;
		}
		// Base case: if n is 1, return 1
		else if (n == 1) {
			return 1;
		}
		// Recursive case: calculate Fibonacci number for n by summing the previous two Fibonacci numbers
		else {
			return fib(n - 1) + fib(n - 2);
		}
	}
}
