package com.epam.jwd.task01.entity.jewel;

import com.epam.jwd.task01.entity.constant.AdditionalTransparencyOption;
import com.epam.jwd.task01.entity.constant.WeightUnit;

import java.math.BigDecimal;
import java.util.Objects;

public class SemipreciousMineralStone extends Gemstone {
    private String semiPreciousMineralStoneName;
    private String silicateCompoundImpurity;
    private AdditionalTransparencyOption additionalTransparencyOption;

    public SemipreciousMineralStone(BigDecimal stoneWeight, WeightUnit weightUnit, BigDecimal stonePrice,
                                    String stoneColor, int transparencyLevel, String semiPreciousMineralStoneName,
                                    String silicateCompoundImpurity,
                                    AdditionalTransparencyOption additionalTransparencyOption) {
        super(stoneWeight, weightUnit, stonePrice, stoneColor, transparencyLevel);
        this.semiPreciousMineralStoneName = semiPreciousMineralStoneName;
        this.silicateCompoundImpurity = silicateCompoundImpurity;
        this.additionalTransparencyOption = additionalTransparencyOption;
    }

    public String getSemiPreciousMineralStoneName() {
        return semiPreciousMineralStoneName;
    }

    public void setSemiPreciousMineralStoneName(String semiPreciousMineralStoneName) {
        this.semiPreciousMineralStoneName = semiPreciousMineralStoneName;
    }

    public String getSilicateCompoundImpurity() {
        return silicateCompoundImpurity;
    }

    public void setSilicateCompoundImpurity(String silicateCompoundImpurity) {
        this.silicateCompoundImpurity = silicateCompoundImpurity;
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
        if (!(o instanceof SemipreciousMineralStone)) return false;
        if (!super.equals(o)) return false;
        SemipreciousMineralStone that;
        that = (SemipreciousMineralStone) o;
        return semiPreciousMineralStoneName.equals(that.semiPreciousMineralStoneName)
                && silicateCompoundImpurity.equals(that.silicateCompoundImpurity)
                && additionalTransparencyOption == that.additionalTransparencyOption;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), semiPreciousMineralStoneName, silicateCompoundImpurity,
                additionalTransparencyOption);
    }

    @Override
    public String toString() {
        return "\n" + this.getSemiPreciousMineralStoneName()
                + " | " + this.getSilicateCompoundImpurity()
                + " | " + this.getAdditionalTransparencyOption()
                + " | " + super.getStoneColor()
                + " | transparency: " + super.getTransparencyLevel() + " %"
                + " | weight: " + super.getStoneWeight() + " " + super.getWeightUnit()
                + " | price: " + super.getStonePrice() + " USD"
                + " | Gemstone ID: " + super.getStoneId();
    }
}
