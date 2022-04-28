package com.epam.jwd.task01.logic;

import com.epam.jwd.task01.entity.jewel.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Base method to add into list <i>Necklace</i> instances of {@link Gemstone} from source list <i>GemstoneList</i>
 *
 * <p>Each <i>Necklace</i> is based on <tt>Arraylist</tt> collection and able to use all relevant methods.
 *
 * <p>Elements to add into <i>Necklace</i> have some restrictions:
 * <p>a) an attempt to duplicate already added element throws <tt>IllegalArgumentException</tt>;
 * <p>b) an attempt to add non-existent element from <i>GemstoneList</i> throws <tt>ArrayIndexOutOfBoundsException</tt>
 *
 * @see GemstoneListCreator
 * @see ArrayList
 */
public class NecklaceCreator {
    private static int id = 0;
    private List<Gemstone> necklace;
    private int necklaceId;

    /**
     * Constructor to create an instance of <i>Necklace</i>, based on empty <tt>Arraylist</tt>.
     * <p>Each initialised Necklace has a unique <i>ID</i>, which is generated automatically by incrementing
     * of static field <tt>id</tt> by one from zero initial value (set by default).
     */
    public NecklaceCreator() {
        this.necklace = new ArrayList<>();
        this.necklaceId = id;
        id++;
    }

    public List<Gemstone> getNecklace() {
        return necklace;
    }

    public int getNecklaceId() {
        return necklaceId;
    }

    /**
     * Adds element from <i>GemstoneList</i> into <i>Necklace</i>
     * <p>In case of trying to duplicate already added element throws <tt>IllegalArgumentException</tt>. This check
     * is performed by comparing of field <tt>gemstoneId</tt> in new element with the corresponding fields of
     * previously added elements.
     * <p>In case of trying to add non-existent element from <i>GemstoneList</i> (non-existent <tt>Arraylist index</tt>)
     * throws <tt>ArrayIndexOutOfBoundsException</tt>
     * @param gemstoneList an instance of <i>GemstoneList</i>, created by {@link GemstoneListCreator}
     * @param gemstoneId a value of field <tt>stoneId</tt> of an instance of {@link Gemstone}
     */
    public void addGemstoneToNecklace(GemstoneListCreator gemstoneList, int gemstoneId) {
        for (Gemstone gemstone : necklace) {
            if (gemstone.getStoneId() == gemstoneId) {
                throw new IllegalArgumentException("The gemstone has already been added to necklace!");
            }
        }
        if (gemstoneId >= gemstoneList.getGemstoneList().size()) {
            throw new ArrayIndexOutOfBoundsException("No such gemstone ID in the list!");
        } else {
            necklace.add(gemstoneList.getGemstoneList().get(gemstoneId));
        }
    }

    @Override
    public String toString() {
        return "Necklace " + necklaceId + ": " + necklace;
    }
}
