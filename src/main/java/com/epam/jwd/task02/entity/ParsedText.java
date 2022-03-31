package com.epam.jwd.task02.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * An arrayList, composed of different types paragraphs
 *
 * @see Paragraph
 */
public class ParsedText implements Iterable<Paragraph> {
    private final List<Paragraph> paragraphList;

    public ParsedText() {
        this.paragraphList = new ArrayList<>();
    }

    public void addNewParagraph(Paragraph paragraph) {
        paragraphList.add(paragraph);
    }

    public int paragraphCount() {
        return paragraphList.size();
    }

    @Override
    public String toString() {
        return paragraphList.toString();
    }

    @Override
    public Iterator<Paragraph> iterator() {
        return new Iterator<Paragraph>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < paragraphList.size();
            }

            @Override
            public Paragraph next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    return paragraphList.get(index++);
                }
            }
        };
    }
}
