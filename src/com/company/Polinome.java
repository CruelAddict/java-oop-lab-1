package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class Polinome {
    FractionSet coefficients;

    public Polinome() {
        coefficients = new FractionSet();
    }

    public Polinome(FractionSet set) {
        coefficients = set.reverese();
    }

    public double calculateFor(double x) {
        double sum = 0;
        int counter = coefficients.getFractions().size() - 1;
        for (Fraction r : coefficients.reverese().getFractions()
        ) {
            sum += r.getValue() * Math.pow(x, counter);
            counter--;
        }
        return sum;
    }

    public Polinome sum(Polinome other) {
        Integer minNumberOfElements = Math.min(
                coefficients.getFractions().size()
                , other.coefficients.getFractions().size()
        );
        return new Polinome(
                new FractionSet(
                        Stream.of(
                                /* iterating over fractions that have to be summed */
                                IntStream.range(0, minNumberOfElements
                                )
                                        .mapToObj(i -> coefficients.get(i)
                                                .sum(other.coefficients.get(i))
                                        )
                                        .collect(toCollection(ArrayList::new)) //
                                ,  /* iterating over fractions that have to be added if this.size > other.size */
                                IntStream.range(minNumberOfElements, coefficients.getFractions().size())
                                        .mapToObj(i -> coefficients.get(i))
                                        .collect(toCollection(ArrayList::new))
                                , /* iterating over fractions that have to be added if other.size > this.size */
                                IntStream.range(minNumberOfElements, other.coefficients.getFractions().size())
                                        .mapToObj(i -> other.coefficients.get(i))
                                        .collect(toCollection(ArrayList::new))
                        ).flatMap(Collection::stream)
                                .collect(Collectors.toList())
                ).reverese()
        );

    }

    @Override
    public String toString() {
        return coefficients.toString();
    }
}