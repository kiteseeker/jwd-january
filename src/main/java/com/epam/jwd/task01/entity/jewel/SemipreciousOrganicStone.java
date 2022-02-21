package com.epam.jwd.task01.entity.jewel;

import com.epam.jwd.task01.entity.constant.AdditionalTransparencyOption;
import com.epam.jwd.task01.entity.constant.WeightUnit;

import java.math.BigDecimal;
import java.util.Objects;

public class SemipreciousOrganicStone extends Gemstone {
    private String semiPreciousOrganicStoneName;
    private String organicSource;
    private AdditionalTransparencyOption additionalTransparencyOption;


    public SemipreciousOrganicStone(BigDecimal stoneWeight, WeightUnit weightUnit, BigDecimal stonePrice,
                                    String stoneColor, int transparencyLevel, String semiPreciousStoneName,
                                    String organicSource,
                                    AdditionalTransparencyOption additionalTransparencyOption) {
        super(stoneWeight, weightUnit, stonePrice, stoneColor, transparencyLevel);
        this.semiPreciousOrganicStoneName = semiPreciousStoneName;
        this.organicSource = organicSource;
        this.additionalTransparencyOption = additionalTransparencyOption;
    }

    public String getSemiPreciousOrganicStoneName() {
        return semiPreciousOrganicStoneName;
    }

    public void setSemiPreciousOrganicStoneName(String semiPreciousOrganicStoneName) {
        this.semiPreciousOrganicStoneName = semiPreciousOrganicStoneName;
    }

    public String getOrganicSource() {
        return organicSource;
    }

    public void setOrganicSource(String organicSource) {
        this.organicSource = organicSource;
    }

    public AdditionalTransparencyOption getAdditionalTransparencyOption() {
        return additionalTransparencyOption;
    }

    public void setAdditionalTransparencyOption(AdditionalTransparencyOption additionalTransparencyOption) {
        this.additionalTransparencyOption = additionalTransparencyOption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SemipreciousOrganicStone)) return false;
        if (!super.equals(o)) return false;
        SemipreciousOrganicStone that;
        that = (SemipreciousOrganicStone) o;
        return semiPreciousOrganicStoneName.equals(that.semiPreciousOrganicStoneName)
                && organicSource.equals(that.organicSource)
                && additionalTransparencyOption == that.additionalTransparencyOption;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), semiPreciousOrganicStoneName, organicSource,
                additionalTransparencyOption);
    }

    @Override
    public String toString() {
        return "\n" + this.getSemiPreciousOrganicStoneName()
                + " | " + this.getOrganicSource()
                + " | " + this.getAdditionalTransparencyOption()
                + " | " + super.getStoneColor()
                + " | transparency: " + super.getTransparencyLevel() + " %"
                + " | weight: " + super.getStoneWeight() + " " + super.getWeightUnit()
                + " | price: " + super.getStonePrice() + " USD"
                + " | Gemstone ID: " + super.getStoneId();
    }
}
