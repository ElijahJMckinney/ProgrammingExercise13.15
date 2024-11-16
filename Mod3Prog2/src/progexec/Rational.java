package progexec;

import java.math.BigInteger;

public class Rational {
    private BigInteger numerator;
    private BigInteger denominator;

    // Default constructor to create a rational number 0/1
    public Rational() {
        this.numerator = BigInteger.ZERO;
        this.denominator = BigInteger.ONE;
    }

    // Constructor to create a rational number with given numerator and denominator
    public Rational(long numerator, long denominator) {
        this.numerator = BigInteger.valueOf(numerator);
        this.denominator = BigInteger.valueOf(denominator);
        normalize();
    }

    // Constructor to create a rational number with BigInteger numerator and denominator
    public Rational(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        normalize();
    }

    // Normalize the rational number by ensuring the denominator is positive
    private void normalize() {
        if (denominator.signum() == -1) {
            numerator = numerator.negate();
            denominator = denominator.negate();
        }
    }

    // Add two rational numbers
    public Rational add(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator)
                .add(other.numerator.multiply(this.denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    // Subtract two rational numbers
    public Rational subtract(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator)
                .subtract(other.numerator.multiply(this.denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    // Multiply two rational numbers
    public Rational multiply(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.numerator);
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    // Divide two rational numbers
    public Rational divide(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator);
        BigInteger newDenominator = this.denominator.multiply(other.numerator);
        return new Rational(newNumerator, newDenominator);
    }

    // Convert the rational number to a decimal
    public double toDecimal() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    // To string representation of the rational number
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Method to display the rational number in decimal format
    public String toDecimalString() {
        return String.valueOf(toDecimal());
    }
}
