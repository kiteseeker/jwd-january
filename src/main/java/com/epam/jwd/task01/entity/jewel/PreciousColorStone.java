package com.epam.jwd.task01.entity.jewel;

import com.epam.jwd.task01.entity.constant.PreciousColorStoneName;
import com.epam.jwd.task01.entity.constant.WeightUnit;

import java.math.BigDecimal;
import java.util.Objects;

public class PreciousColorStone extends Gemstone {
    private PreciousColorStoneName preciousStoneName;
    private String chemicalCompound;

    public PreciousColorStone(BigDecimal stoneWeight, WeightUnit weightUnit, BigDecimal stonePrice, String stoneColor,
                              int transparencyLevel, PreciousColorStoneName preciousStoneName,
                              String chemicalCompound) {
        super(stoneWeight, weightUnit, stonePrice, stoneColor, transparencyLevel);
        this.preciousStoneName = preciousStoneName;
        this.chemicalCompound = chemicalCompound;
    }

    public PreciousColorStoneName getPreciousStoneName() {
        return preciousStoneName;
    }

    public void setPreciousStoneName(PreciousColorStoneName preciousStoneName) {
        this.preciousStoneName = preciousStoneName;
    }

    public String getChemicalCompound() {
        return chemicalCompound;
    }

    public void setChemicalCompound(String chemicalCompound) {
        this.chemicalCompound = chemicalCompound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PreciousColorStone)) return false;
        if (!super.equals(o)) return false;
        PreciousColorStone that;
        that = (PreciousColorStone) o;
        return preciousStoneName.equals(that.preciousStoneName)
                && chemicalCompound.equals(that.chemicalCompound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), preciousStoneName, chemicalCompound);
    }

    @Override
    public String toString() {
        return "\n" + this.getPreciousStoneName()
                + " | " + this.getChemicalCompound()
                + " | " + super.getStoneColor()
                + " | transparency: " + super.getTransparencyLevel() + " %"
                + " | weight: " + super.getStoneWeight() + " " + super.getWeightUnit()
                + " | price: " + super.getStonePrice() + " USD"
                + " | Gemstone ID: " + super.getStoneId();
    }
}
