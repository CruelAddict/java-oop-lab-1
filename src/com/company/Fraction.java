package com.company;

public class Fraction implements Comparable<Fraction> {
    private final double numenator;
    private final double divider;

    public Fraction(double numenator, double divider) {
        this.numenator = numenator;
        this.divider = divider;
    }

    public Double getNumenator() {
        return numenator;
    }

    public Double getDivider() {
        return divider;
    }

    public Double getValue() {
        return numenator / divider;
    }

    public Fraction sum(Fraction other) {
        return new Fraction(this.getNumenator() * other.getDivider() + other.getNumenator() * this.getDivider()
                , this.getDivider() * other.getDivider());
    }

    @Override
    public String toString() {
        return Double.toString(this.getValue());
    }

    @Override
    public int compareTo(Fraction fraction) {
        return Double.compare(this.getValue(), fraction.getValue());
    }
}
