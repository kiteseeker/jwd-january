package com.epam.jwd.task01.logic;

import com.epam.jwd.task01.entity.constant.SortOrderName;
import com.epam.jwd.task01.entity.jewel.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class  containing only methods for sorting and filtering of elements {@link Gemstone}
 * in {@link NecklaceCreator} <i>Necklace</i>
 * <p> No instances of this class can exist, and all its fields and methods are static.
 * <p>Sorting method is based on {@link ComparatorStonesByPrice} <i>comparator</i>
 * <p>Filtering method is based on the field <tt>TransparencyLevel</tt> of the elements
 *
 * @see NecklaceCreator
 * @see ComparatorStonesByPrice
 */
public final class NecklaceSortAndFilterMaker {

    private NecklaceSortAndFilterMaker() {

    }

    /**
     * Sort elements {@link Gemstone} in <i>Necklace</i> by the field <tt>stonePrice</tt> in the given order
     *
     * @param necklace an instance of <i>Necklace</i>, created by {@link NecklaceCreator}
     * @param order    sort order based on enum {@link SortOrderName}
     */
    public static void sortGemsByPrice(NecklaceCreator necklace, SortOrderName order) {
        if (order == SortOrderName.ASC) {
            necklace.getNecklace().sort(new ComparatorStonesByPrice());
            System.out.println("Stones sorted by price (ACS) in " + necklace);
        } else if (order == SortOrderName.DESC) {
            necklace.getNecklace().sort(new ComparatorStonesByPrice().reversed());
            System.out.println("Stones sorted by price (DESC) in " + necklace);
        }
    }

    /**
     * Filter elements {@link Gemstone} in <i>Necklace</i> by the field <tt>TransparencyLevel</tt> in the given range
     *
     * @param necklace        an instance of <i>Necklace</i>, created by {@link NecklaceCreator}
     * @param minTransparency lower range limit of the field <tt>TransparencyLevel</tt> of the elements
     * @param maxTransparency upper range limit of the field <tt>TransparencyLevel</tt> of the elements
     */
    public static void filterStonesByTransparency(NecklaceCreator necklace, int minTransparency, int maxTransparency) {
        List<Gemstone> filteredList = new ArrayList<>();
        for (Gemstone gemstone : necklace.getNecklace()) {
            if (gemstone.getTransparencyLevel() >= minTransparency
                    && gemstone.getTransparencyLevel() <= maxTransparency) {
                filteredList.add(gemstone);
            }
        }
        System.out.println("Selected stones from Necklace " + necklace.getNecklaceId() + ": "
                + filteredList);
    }
}
