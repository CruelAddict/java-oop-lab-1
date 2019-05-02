package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FractionSet {

    private List<Fraction> fractions;

    public FractionSet() {
        this.fractions = new ArrayList<>();
    }

    public FractionSet(List<Fraction> list) {
        this.fractions = list;
    }

    public void append(Fraction r) {
        fractions.add(r);
    }

    public Fraction getMax() {
        return fractions.stream().max(Comparator.comparing(Fraction::getValue)).get();
    }

    public Fraction getMin() {
        return fractions.stream().min(Comparator.comparing(Fraction::getValue)).get();
    }

    public int countLessThan(Fraction other) {
        return (int) fractions.stream().filter(fraction -> fraction.compareTo(other) < 0.0).count();
    }

    public int countGreaterThan(Fraction other) {
        return (int) fractions.stream().filter(fraction -> fraction.compareTo(other) > 0.0).count();
    }

    public FractionSet reverese() {
        List<Fraction> newFractions = new ArrayList<>();
        for (int i = fractions.size()-1; i > -1; i--) {
            newFractions.add(fractions.get(i));
        }
        return new FractionSet(newFractions);
    }

    List<Fraction> getFractions() {
        return Collections.unmodifiableList(fractions);
    }

    Fraction get(int index) {
        return fractions.get(index);
    }

    @Override
    public String toString() {
        return this.reverese().fractions.stream().map(f -> f.toString()).collect(Collectors.joining(", "));
    }
}
