package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        FractionSet fractionSet = new FractionSet();
        fractionSet.append(new Fraction(1, 10));
        fractionSet.append(new Fraction(9, 10));
        fractionSet.append(new Fraction(2, 4));
        System.out.println("A fraction set has been created: " + fractionSet);
        System.out.println("Its greatest value is " + fractionSet.getMax());
        System.out.println("Its lowest value is " + fractionSet.getMin());
        System.out.println("Number of elements in this set that are less than 0.2 is " + fractionSet.countLessThan(new Fraction(2, 10)));
        System.out.println("Number of elements in this set that are greater than 0.4 is " + fractionSet.countGreaterThan(new Fraction(4, 10)));
        Polinome polinome = new Polinome(fractionSet);
        System.out.println("A polinome has been created from this set. Its value in x = 2 is " + polinome.calculateFor(2));
        Polinome polinome1 = new Polinome(new FractionSet(Arrays.asList(new Fraction(15, 100), new Fraction(25, 100))));
        Polinome summedPolinome = polinome.sum(polinome1);
        System.out.println("This polinome ("+polinome+") summed with polinome " + polinome1 + " is " + summedPolinome);
    }
}
