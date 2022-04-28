package com.epam.jwd.task01.logic.validator;

import com.epam.jwd.task01.entity.jewel.Gemstone;

import java.math.BigDecimal;

/**
 * Method for validation of some fields values, specified at the time of creation of <tt>new</tt>
 * instances of {@link Gemstone}.
 * <p>Throws <tt>IllegalArgumentException</tt> if specified values are out of a given range.
 */
public class GemstoneValidator {

    /**
     * Validates fields <tt>stoneWeight</tt>, <tt>stonePrice</tt>, <tt>transparencyLevel</tt> of {@link Gemstone}
     * @param gemstone created instance of {@link Gemstone}
     */
    public void validateGemstone(Gemstone gemstone) {
        validateStoneWeight(gemstone.getStoneWeight());
        validateStonePrice(gemstone.getStonePrice());
        validateTransparencyLevel(gemstone.getTransparencyLevel());
    }

    /**
     * Validates value, specified in the field <tt>transparencyLevel</tt> of {@link Gemstone}
     *
     * @param transparencyLevel an <tt>int</tt>-type value of an instance of {@link Gemstone} transparency.
     *                          If the value is out of range [0, 100] throws <tt>IllegalArgumentException</tt>.
     */
    private void validateTransparencyLevel(int transparencyLevel) {
        if (transparencyLevel < 0 || transparencyLevel > 100) {
            throw new IllegalArgumentException("Select transparency level between 0 and 100 %");
        }
    }

    /**
     * Validates value, specified in the field <tt>stonePrice</tt> of {@link Gemstone}
     *
     * @param stonePrice a <tt>BigDecimal</tt> value of price. If the value is less or equal to zero,
     *                   throws <tt>IllegalArgumentException</tt>
     */
    private void validateStonePrice(BigDecimal stonePrice) {
        if (stonePrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero!");
        }
    }

    /**
     * Validates value, specified in the field <tt>stoneWeight</tt> of {@link Gemstone}
     *
     * @param stoneWeight a <tt>BigDecimal</tt> value of weight. If the value is less or equal to zero,
     *                    throws <tt>IllegalArgumentException</tt>
     */
    private void validateStoneWeight(BigDecimal stoneWeight) {
        if (stoneWeight.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero!");
        }
    }
}
