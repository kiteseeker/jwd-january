package com.epam.jwd.task01.logic;

import com.epam.jwd.task01.entity.constant.WeightUnit;
import com.epam.jwd.task01.entity.jewel.Gemstone;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utility class, containing only methods for calculating {@link NecklaceCreator} <i>Necklace</i> instances
 * total cost and weight.
 * <p>No instances of this class can exist, and all its fields and methods are static.
 * <p>Weight of the elements in <i>Necklace</i> can be specified either as GRAM or CARAT in accordance with
 * {@link WeightUnit}. Method {@link #calculateNecklaceTotalCaratWeight(NecklaceCreator)} performs automatic
 * gram to carat conversion (one carat equals to 0.2 gram) and calculates the result value in carats.
 * <p>Calculation results are <tt>BigDecimal</tt>, weight result is rounded up to two decimals using
 * {@link BigDecimal#setScale(int, RoundingMode)} method.
 *
 * @see NecklaceCreator
 * @see WeightUnit
 * @see BigDecimal#ZERO
 * @see BigDecimal#setScale(int, RoundingMode)
 */
public final class NecklaceCalculator {
    private static final BigDecimal GRAM_TO_CARAT_COEFFICIENT = BigDecimal.valueOf(0.2);

    private NecklaceCalculator() {

    }

    /**
     * Calculates the sum of values in fields <tt>StonePrice</tt> of <i>Necklace</i> elements as <tt>BigDecimal</tt>.
     *
     * @param necklace an instance of <i>Necklace</i>, created by {@link NecklaceCreator}
     * @return {@link BigDecimal} total <i>Necklace</i> elements cost value
     */
    public static BigDecimal calculateNecklaceTotalCost(NecklaceCreator necklace) {
        BigDecimal totalStonesCost = BigDecimal.ZERO;
        for (Gemstone gemstone : necklace.getNecklace()) {
            totalStonesCost = totalStonesCost.add(gemstone.getStonePrice());
        }
        return totalStonesCost;
    }

    /**
     * Calculates the sum of values in fields <tt>stoneWeight</tt> of <i>Necklace</i> elements as <tt>BigDecimal</tt>.
     *
     * @param necklace an instance of <i>Necklace</i>, created by {@link NecklaceCreator#NecklaceCreator()}
     * @return {@link BigDecimal} total <i>Necklace</i> elements weight value in carats
     */
    public static BigDecimal calculateNecklaceTotalCaratWeight(NecklaceCreator necklace) {
        BigDecimal totalStonesWeight = BigDecimal.ZERO;
        for (Gemstone gemstone : necklace.getNecklace()) {
            if (gemstone.getWeightUnit() == WeightUnit.GRAM) {
                totalStonesWeight = totalStonesWeight.add(gemstone.getStoneWeight().divide(GRAM_TO_CARAT_COEFFICIENT));
            } else {
                totalStonesWeight = totalStonesWeight.add(gemstone.getStoneWeight());
            }
        }
        return totalStonesWeight.setScale(2, RoundingMode.HALF_UP);
    }
}
