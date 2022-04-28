package com.epam.jwd.task01.entity.jewel;

import com.epam.jwd.task01.entity.constant.WeightUnit;

import java.math.BigDecimal;
import java.util.Objects;

public class PreciousDiamondStone extends Gemstone {
    private static final String STONE_NAME = "DIAMOND";
    private String brilliantCutType;


    public PreciousDiamondStone(BigDecimal stoneWeight, WeightUnit weightUnit, BigDecimal stonePrice, String stoneColor,
                                int transparencyLevel, String preciousDiamondStoneCut) {
        super(stoneWeight, weightUnit, stonePrice, stoneColor, transparencyLevel);
        brilliantCutType = preciousDiamondStoneCut;
    }

    public String getBrilliantCutType() {
        return brilliantCutType;
    }

    public void setBrilliantCutType(String brilliantCutType) {
        this.brilliantCutType = brilliantCutType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PreciousDiamondStone)) return false;
        if (!super.equals(o)) return false;
        PreciousDiamondStone that;
        that = (PreciousDiamondStone) o;
        return brilliantCutType.equals(that.brilliantCutType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brilliantCutType);
    }

    @Override
    public String toString() {
        return "\n" + STONE_NAME
                + " | " + this.getBrilliantCutType()
                + " | " + super.getStoneColor()
                + " | transparency: " + super.getTransparencyLevel() + " %"
                + " | weight: " + super.getStoneWeight() + " " + super.getWeightUnit()
                + " | price: " + super.getStonePrice() + " USD"
                + " | Gemstone ID: " + super.getStoneId();
    }
}
