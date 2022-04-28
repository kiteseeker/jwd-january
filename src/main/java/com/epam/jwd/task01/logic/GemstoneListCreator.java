package com.epam.jwd.task01.logic;

import com.epam.jwd.task01.entity.constant.AdditionalTransparencyOption;
import com.epam.jwd.task01.entity.constant.PreciousColorStoneName;
import com.epam.jwd.task01.entity.constant.WeightUnit;
import com.epam.jwd.task01.entity.jewel.*;
import com.epam.jwd.task01.logic.validator.GemstoneValidator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Base method to create and add into list <i>GemstoneList</i> instances of {@link Gemstone}
 *
 * <p>Each <i>GemstoneList</i> is based on <tt>Arraylist</tt> collection and able to use all relevant methods.
 *
 * <p>Each element of <i>GemstoneList</i> has restrictions on some fields values. For example, negative and zero
 * values are prohibited for the fields, containing weight and price. Attempting to add an ineligible value throws an
 * unchecked <tt>IllegalArgumentException</tt>. This check is performed by <tt>Validator</tt> class.
 *
 * @see ArrayList
 * @see GemstoneValidator
 */
public class GemstoneListCreator {
    private List<Gemstone> gemstoneList;
    private GemstoneValidator validator;

    /**
     * Constructor to create an instance of <i>GemstoneList</i>, based on empty <tt>Arraylist</tt>.
     * <p>New <tt>Validator</tt> instance is added automatically after <i>GemstoneList</i> initialization.
     */
    public GemstoneListCreator() {
        this.gemstoneList = new ArrayList<>();
        this.validator = new GemstoneValidator();
    }

    /**
     * Creates, validates and adds to <i>GemstoneList</i> an instance of {@link PreciousDiamondStone}
     *
     * @param stoneWeight             a <tt>BigDecimal</tt> value of weight. If the value is less or equal to zero,
     *                                throws <tt>IllegalArgumentException</tt>. This check is performed by
     *                                <tt>Validator</tt>.
     * @param weightUnit              a value of weight unit based on enum {@link WeightUnit}.
     * @param stonePrice              a <tt>BigDecimal</tt> value of price. If the value is less or equal to zero,
     *                                throws <tt>IllegalArgumentException</tt>. This check is performed by
     *                                <tt>Validator</tt>.
     * @param stoneColor              a string to display an instance of {@link Gemstone} color.
     * @param transparencyLevel       an <tt>int</tt>-type value of an instance of {@link Gemstone} transparency.
     *                                If the value is out of range [0, 100] throws <tt>IllegalArgumentException</tt>.
     *                                This check is performed by <tt>Validator</tt>.
     * @param preciousDiamondStoneCut a string to display <tt>PreciousDiamondStone</tt> cut.
     *
     * @see GemstoneValidator
     */
    public void addPreciousDiamondStoneToList(BigDecimal stoneWeight, WeightUnit weightUnit,
                                              BigDecimal stonePrice, String stoneColor, int transparencyLevel,
                                              String preciousDiamondStoneCut) {

        PreciousDiamondStone preciousDiamondStone = new PreciousDiamondStone(stoneWeight, weightUnit, stonePrice,
                stoneColor, transparencyLevel, preciousDiamondStoneCut);

        preciousDiamondStone.setStoneWeight(stoneWeight);
        preciousDiamondStone.setWeightUnit(weightUnit);
        preciousDiamondStone.setStonePrice(stonePrice);
        preciousDiamondStone.setStoneColor(stoneColor);
        preciousDiamondStone.setTransparencyLevel(transparencyLevel);
        preciousDiamondStone.setBrilliantCutType(preciousDiamondStoneCut);

        validator.validateGemstone(preciousDiamondStone);
        gemstoneList.add(preciousDiamondStone);
    }

    /**
     * Creates, validates and adds to <i>GemstoneList</i> an instance of {@link PreciousColorStone}
     *
     * @param stoneWeight       a <tt>BigDecimal</tt> value of weight. If the value is less or equal to zero,
     *                          throws <tt>IllegalArgumentException</tt>. This check is performed by <tt>Validator</tt>.
     * @param weightUnit        a value of weight unit based on enum {@link WeightUnit}.
     * @param stonePrice        a <tt>BigDecimal</tt> value of price. If the value is less or equal to zero,
     *                          throws <tt>IllegalArgumentException</tt>. This check is performed by
     *                          <tt>Validator</tt>.
     * @param stoneColor        a string to display an instance of {@link Gemstone} color.
     * @param transparencyLevel an <tt>int</tt>-type value of an instance of {@link Gemstone} transparency.
     *                          If the value is out of range [0, 100] throws <tt>IllegalArgumentException</tt>.
     *                          This check is performed by <tt>Validator</tt>.
     * @param preciousStoneName a text to display <tt>PreciousColorStoneToList</tt> name,
     *                          based on enum {@link PreciousColorStoneName}.
     * @param chemicalCompound  a text to display main chemical compound and impurities, responsible for current
     *                          <tt>PreciousColorStone</tt> color and other properties
     *
     * @see GemstoneValidator
     */
    public void addPreciousColorStoneToList(BigDecimal stoneWeight, WeightUnit weightUnit,
                                            BigDecimal stonePrice, String stoneColor, int transparencyLevel,
                                            PreciousColorStoneName preciousStoneName,
                                            String chemicalCompound) {

        PreciousColorStone preciousColorStone = new PreciousColorStone(stoneWeight, weightUnit, stonePrice,
                stoneColor, transparencyLevel, preciousStoneName, chemicalCompound);

        preciousColorStone.setStoneWeight(stoneWeight);
        preciousColorStone.setWeightUnit(weightUnit);
        preciousColorStone.setStonePrice(stonePrice);
        preciousColorStone.setStoneColor(stoneColor);
        preciousColorStone.setTransparencyLevel(transparencyLevel);
        preciousColorStone.setPreciousStoneName(preciousStoneName);
        preciousColorStone.setChemicalCompound(chemicalCompound);

        validator.validateGemstone(preciousColorStone);
        gemstoneList.add(preciousColorStone);
    }

    /**
     * Creates, validates and adds to <i>GemstoneList</i> an instance of {@link SemipreciousMineralStone}
     *
     * @param stoneWeight                  a <tt>BigDecimal</tt> value of weight. If the value is less or equal to zero,
     *                                     throws <tt>IllegalArgumentException</tt>. This check is performed by
     *                                     <tt>Validator</tt>.
     * @param weightUnit                   a value of weight unit based on enum {@link WeightUnit}.
     * @param stonePrice                   a <tt>BigDecimal</tt> value of price. If the value is less or equal to zero,
     *                                     throws <tt>IllegalArgumentException</tt>. This check is performed by
     *                                     <tt>Validator</tt>.
     * @param stoneColor                   a string to display an instance of {@link Gemstone} color.
     * @param transparencyLevel            an <tt>int</tt>-type value of an instance of {@link Gemstone} transparency.
     *                                     If the value is out of range [0, 100] throws
     *                                     <tt>IllegalArgumentException</tt>. This check is performed by
     *                                     <tt>Validator</tt>.
     * @param semiPreciousMineralStoneName a text to display <tt>SemipreciousMineralStone</tt> name
     * @param silicateCompoundImpurity     a text to display main chemical compound and impurities, responsible
     *                                     for current <tt>SemipreciousMineralStone</tt> color, transparency
     *                                     and other properties
     * @param additionalTransparencyOption a value of additional possible <tt>SemipreciousMineralStone</tt> transparency
     *                                     option, based on enum {@link AdditionalTransparencyOption}.
     *
     * @see GemstoneValidator
     */
    public void addSemipreciousMineralStoneToList(BigDecimal stoneWeight, WeightUnit weightUnit, BigDecimal stonePrice,
                                                  String stoneColor, int transparencyLevel,
                                                  String semiPreciousMineralStoneName,
                                                  String silicateCompoundImpurity,
                                                  AdditionalTransparencyOption additionalTransparencyOption) {

        SemipreciousMineralStone semipreciousMineralStone = new SemipreciousMineralStone(stoneWeight, weightUnit,
                stonePrice, stoneColor, transparencyLevel, semiPreciousMineralStoneName, silicateCompoundImpurity,
                additionalTransparencyOption);

        semipreciousMineralStone.setStoneWeight(stoneWeight);
        semipreciousMineralStone.setWeightUnit(weightUnit);
        semipreciousMineralStone.setStonePrice(stonePrice);
        semipreciousMineralStone.setStoneColor(stoneColor);
        semipreciousMineralStone.setTransparencyLevel(transparencyLevel);
        semipreciousMineralStone.setSemiPreciousMineralStoneName(semiPreciousMineralStoneName);
        semipreciousMineralStone.setSilicateCompoundImpurity(silicateCompoundImpurity);
        semipreciousMineralStone.setAdditionalTransparencyOption(additionalTransparencyOption);

        validator.validateGemstone(semipreciousMineralStone);
        gemstoneList.add(semipreciousMineralStone);

    }

    /**
     * Creates, validates and adds to <i>GemstoneList</i> an instance of {@link SemipreciousOrganicStone}
     *
     * @param stoneWeight                  a <tt>BigDecimal</tt> value of weight. If the value is less or equal to zero,
     *                                     throws <tt>IllegalArgumentException</tt>. This check is performed by
     *                                     <tt>Validator</tt>.
     * @param weightUnit                   a value of weight unit based on enum {@link WeightUnit}.
     * @param stonePrice                   a <tt>BigDecimal</tt> value of price. If the value is less or equal to zero,
     *                                     throws <tt>IllegalArgumentException</tt>. This check is performed by
     *                                     <tt>Validator</tt>.
     * @param stoneColor                   a string to display an instance of {@link Gemstone} color.
     * @param transparencyLevel            an <tt>int</tt>-type value of an instance of {@link Gemstone} transparency.
     *                                     If the value is out of range [0, 100] throws
     *                                     <tt>IllegalArgumentException</tt>. This check is performed by
     *                                     <tt>Validator</tt>.
     * @param semiPreciousStoneName        a text to display <tt>SemipreciousOrganicStone</tt> name
     * @param organicSource                a text to display main organic source for <tt>SemipreciousOrganicStone</tt>
     *                                     creation, responsible for color, transparency and other properties
     * @param additionalTransparencyOption a value of additional possible <tt>SemipreciousOrganicStone</tt> transparency
     *                                     option, based on enum {@link AdditionalTransparencyOption}.
     * @see GemstoneValidator
     */
    public void addSemipreciousOrganicStoneToList(BigDecimal stoneWeight, WeightUnit weightUnit,
                                                  BigDecimal stonePrice, String stoneColor, int transparencyLevel,
                                                  String semiPreciousStoneName, String organicSource,
                                                  AdditionalTransparencyOption additionalTransparencyOption) {

        SemipreciousOrganicStone semipreciousOrganicStone = new SemipreciousOrganicStone(stoneWeight, weightUnit,
                stonePrice, stoneColor, transparencyLevel, semiPreciousStoneName, organicSource,
                additionalTransparencyOption);

        semipreciousOrganicStone.setStoneWeight(stoneWeight);
        semipreciousOrganicStone.setWeightUnit(weightUnit);
        semipreciousOrganicStone.setStonePrice(stonePrice);
        semipreciousOrganicStone.setStoneColor(stoneColor);
        semipreciousOrganicStone.setTransparencyLevel(transparencyLevel);
        semipreciousOrganicStone.setSemiPreciousOrganicStoneName(semiPreciousStoneName);
        semipreciousOrganicStone.setOrganicSource(organicSource);
        semipreciousOrganicStone.setAdditionalTransparencyOption(additionalTransparencyOption);

        validator.validateGemstone(semipreciousOrganicStone);
        gemstoneList.add(semipreciousOrganicStone);
    }

    public List<Gemstone> getGemstoneList() {
        return gemstoneList;
    }

    @Override
    public String toString() {
        return "List of available gemstones: " + gemstoneList;
    }
}
