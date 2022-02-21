package com.epam.jwd.task01.logic;

import com.epam.jwd.task01.entity.jewel.Gemstone;

import java.util.Comparator;

/**
 * A comparison function, which uses values of the field <tt>stonePrice</tt> in instances of {@link Gemstone}
 */
public class ComparatorStonesByPrice implements Comparator<Gemstone> {

    /**
     * Compares two arguments for order. Returns a negative integer, zero, or a positive integer as
     * the first argument is less than, equal to, or greater than the second.
     * @param gemstone1 the first instance of {@link Gemstone} to be compared
     * @param gemstone2 the second instance of {@link Gemstone} to be compared
     * @return a negative integer, zero, or a positive integer as the first argument is less than,
     * equal to, or greater than the second
     */
    @Override
    public int compare(Gemstone gemstone1, Gemstone gemstone2) {
        return (gemstone1.getStonePrice().compareTo(gemstone2.getStonePrice()));
    }
}
