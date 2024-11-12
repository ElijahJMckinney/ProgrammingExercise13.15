package progexec;

import java.util.Scanner;

public class TestRational {
    public static void main(String[] args) {
        try (var input = new Scanner(System.in)) {
			// Prompt the user to enter two rational numbers
			System.out.print("Enter the first rational number: ");
			long num1 = input.nextLong();
			long den1 = input.nextLong();
			Rational r1 = new Rational(num1, den1);

			System.out.print("Enter the second rational number: ");
			long num2 = input.nextLong();
			long den2 = input.nextLong();
			Rational r2 = new Rational(num2, den2);

			// Perform the arithmetic operations
			Rational sum = r1.add(r2);
			Rational difference = r1.subtract(r2);
			Rational product = r1.multiply(r2);
			Rational quotient = r1.divide(r2);

			// Display the results
			System.out.println(r1 + " + " + r2 + " = " + sum);
			System.out.println(r1 + " - " + r2 + " = " + difference);
			System.out.println(r1 + " * " + r2 + " = " + product);
			System.out.println(r1 + " / " + r2 + " = " + quotient);
			System.out.println(r2 + " is " + r2.toDecimalString());
		}
    }
}
