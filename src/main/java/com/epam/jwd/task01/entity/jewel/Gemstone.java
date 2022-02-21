package com.epam.jwd.task01.entity.jewel;

import com.epam.jwd.task01.entity.constant.WeightUnit;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * The superclass in the <i>gemstones hierarchy</i>
 *
 * <p>Each instance has a unique <i>ID</i>, based on <tt>private</tt> <tt>static</tt> <tt>int</tt>
 * with initial value of 0, which is <i>incremented</i> by 1 after creating each new <i>Gemstone</i>.
 *
 * @see PreciousColorStone
 * @see PreciousColorStone
 * @see SemipreciousMineralStone
 * @see SemipreciousOrganicStone
 */
public abstract class Gemstone {
    private static int id = 0;
    private int stoneId;
    private BigDecimal stoneWeight;
    private WeightUnit weightUnit;
    private BigDecimal stonePrice;
    private String stoneColor;
    private int transparencyLevel;

    protected Gemstone(BigDecimal stoneWeight, WeightUnit weightUnit, BigDecimal stonePrice, String stoneColor,
                    int transparencyLevel) {

        this.stoneWeight = stoneWeight;
        this.stonePrice = stonePrice;
        this.weightUnit = weightUnit;
        this.stoneColor = stoneColor;
        this.transparencyLevel = transparencyLevel;
        this.stoneId = id;
        id++;
    }

    public int getStoneId() {
        return stoneId;
    }

    public BigDecimal getStoneWeight() {
        return stoneWeight;
    }

    public void setStoneWeight(BigDecimal stoneWeight) {
        this.stoneWeight = stoneWeight;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }

    public BigDecimal getStonePrice() {
        return stonePrice;
    }

    public void setStonePrice(BigDecimal stonePrice) {
        this.stonePrice = stonePrice;
    }

    public String getStoneColor() {
        return stoneColor;
    }

    public void setStoneColor(String stoneColor) {
        this.stoneColor = stoneColor;
    }

    public int getTransparencyLevel() {
        return transparencyLevel;
    }

    public void setTransparencyLevel(int transparencyLevel) {
        this.transparencyLevel = transparencyLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gemstone)) return false;
        Gemstone gemstone;
        gemstone = (Gemstone) o;
        return transparencyLevel == gemstone.transparencyLevel
                && stoneWeight.equals(gemstone.stoneWeight)
                && weightUnit.equals(gemstone.weightUnit)
                && stonePrice.equals(gemstone.stonePrice)
                && stoneColor.equals(gemstone.stoneColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stoneWeight, weightUnit, stonePrice, stoneColor, transparencyLevel);
    }

    @Override
    public String toString() {
        return " | transparency: " + transparencyLevel + " %"
                + " | weight: " + stoneWeight + " " + weightUnit
                + " | price: " + stonePrice + " USD"
                + " | Gemstone id: " + stoneId;
    }
}
