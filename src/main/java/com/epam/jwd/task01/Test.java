package com.epam.jwd.task01;

import com.epam.jwd.task01.entity.constant.AdditionalTransparencyOption;
import com.epam.jwd.task01.entity.constant.PreciousColorStoneName;
import com.epam.jwd.task01.entity.constant.SortOrderName;
import com.epam.jwd.task01.logic.GemstoneListCreator;
import com.epam.jwd.task01.entity.constant.WeightUnit;
import com.epam.jwd.task01.logic.NecklaceCreator;
import com.epam.jwd.task01.logic.JewelsInfoPrinter;
import com.epam.jwd.task01.logic.NecklaceSortAndFilterMaker;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {

        GemstoneListCreator gemstoneList = new GemstoneListCreator();

        gemstoneList.addPreciousDiamondStoneToList(
                BigDecimal.valueOf(0.88),
                WeightUnit.CARAT,
                BigDecimal.valueOf(2839.34),
                "colorless",
                83,
                "magna cut");

        gemstoneList.addPreciousDiamondStoneToList(
                BigDecimal.valueOf(0.61),
                WeightUnit.CARAT,
                BigDecimal.valueOf(4558.5),
                "yellow",
                98,
                "royal cut");

        gemstoneList.addSemipreciousMineralStoneToList(
                BigDecimal.valueOf(1.77),
                WeightUnit.GRAM,
                BigDecimal.valueOf(2886.32),
                "yellow",
                79,
                "Topaz",
                "Fe, Ti, Cr",
                AdditionalTransparencyOption.TRANSLUCENT);

        gemstoneList.addSemipreciousMineralStoneToList(
                BigDecimal.valueOf(2.12),
                WeightUnit.GRAM,
                BigDecimal.valueOf(1760.25),
                "pale yellow",
                44,
                "Citrine",
                "pure quartz",
                AdditionalTransparencyOption.SEMITRANSLUCENT);

        gemstoneList.addSemipreciousOrganicStoneToList(
                BigDecimal.valueOf(0.28),
                WeightUnit.GRAM,
                BigDecimal.valueOf(470.57),
                "white",
                0,
                "Pearl",
                "freshwater pearl mussel",
                AdditionalTransparencyOption.OPAQUE);

        gemstoneList.addPreciousColorStoneToList(
                BigDecimal.valueOf(1.58),
                WeightUnit.CARAT,
                BigDecimal.valueOf(3675.14),
                "red",
                84,
                PreciousColorStoneName.RUBY,
                "aluminum oxide, Cr");

        gemstoneList.addPreciousColorStoneToList(
                BigDecimal.valueOf(1.28),
                WeightUnit.CARAT,
                BigDecimal.valueOf(2290.22),
                "green",
                66,
                PreciousColorStoneName.EMERALD,
                "beryl, Cr, V");

        JewelsInfoPrinter.printGemstoneList(gemstoneList);

        NecklaceCreator necklace1 = new NecklaceCreator();
        necklace1.addGemstoneToNecklace(gemstoneList, 0);
        necklace1.addGemstoneToNecklace(gemstoneList, 2);
        necklace1.addGemstoneToNecklace(gemstoneList, 3);
        necklace1.addGemstoneToNecklace(gemstoneList, 5);
        necklace1.addGemstoneToNecklace(gemstoneList, 6);

        JewelsInfoPrinter.printNecklace(necklace1);

        JewelsInfoPrinter.printNecklaceWeight(necklace1);
        JewelsInfoPrinter.printNecklaceCost(necklace1);

        NecklaceSortAndFilterMaker.sortGemsByPrice(necklace1, SortOrderName.DESC);
        NecklaceSortAndFilterMaker.filterStonesByTransparency(necklace1, 70, 100);

    }
}
