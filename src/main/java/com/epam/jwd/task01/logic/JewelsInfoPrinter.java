package com.epam.jwd.task01.logic;

import java.util.ArrayList;

/**
 * Utility class, containing only:
 * <p>a) methods for console output of {@link GemstoneListCreator} <i>GemstoneList</i> and
 * {@link NecklaceCreator} <i>Necklace</i>, which both are instances of <tt>ArrayList</tt> collection and able to use
 * all relevant methods;
 * <p>b) methods for console output of {@link NecklaceCalculator} methods for current <i>Necklace</i> instance.
 * <p>No instances of this class can exist, and all its fields and methods are static.
 *
 * @see GemstoneListCreator
 * @see NecklaceCreator
 * @see NecklaceCalculator
 */
public final class JewelsInfoPrinter {

    private JewelsInfoPrinter() {

    }

    /**
     * Outputs in console an instance of <i>GemstoneList</i> as {@link ArrayList#toString()}
     * @param gemstoneList an instance of <i>GemstoneList</i>, created by {@link GemstoneListCreator}
     */
    public static void printGemstoneList(GemstoneListCreator gemstoneList) {
        System.out.println(gemstoneList);
    }

    /**
     * Outputs in console an instance of <i>Necklace</i> as {@link ArrayList#toString()}
     * @param necklace an instance of <i>Necklace</i>, created by {@link NecklaceCreator}
     */
    public static void printNecklace(NecklaceCreator necklace) {
        System.out.println(necklace);
    }

    /**
     * Outputs in console the result of {@link NecklaceCalculator#calculateNecklaceTotalCost(NecklaceCreator)}
     * @param necklace an instance of <i>Necklace</i>, created by {@link NecklaceCreator}
     */
    public static void printNecklaceCost(NecklaceCreator necklace) {
        System.out.println("Necklace " + necklace.getNecklaceId() + " total cost is "
                + NecklaceCalculator.calculateNecklaceTotalCost(necklace) + " USD.");
    }

    /**
     *  Outputs in console the result of {@link NecklaceCalculator#calculateNecklaceTotalCaratWeight(NecklaceCreator)}
     * @param necklace an instance of <i>Necklace</i>, created by {@link NecklaceCreator}
     */
    public static void printNecklaceWeight(NecklaceCreator necklace) {
        System.out.println("Necklace " + necklace.getNecklaceId() + " total gemstones weight is "
                + NecklaceCalculator.calculateNecklaceTotalCaratWeight(necklace) + " CARAT.");
    }
}
