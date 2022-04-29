package com.epam.jwd.task02.entity;

import com.epam.jwd.task02.entity.enums.ParagraphType;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * An arrayList, composed of sentences
 *
 * @see Sentence
 */
public abstract class Paragraph implements Iterable<Sentence> {
    private final List<Sentence> sentenceList;

    Paragraph(List<Sentence> paragraph) {
        this.sentenceList = paragraph;
    }

    public abstract ParagraphType paragraphType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paragraph)) return false;
        Paragraph sentences = (Paragraph) o;
        return sentenceList.equals(sentences.sentenceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentenceList);
    }

    @Override
    public String toString() {
        return sentenceList.toString();
    }

    public Iterator<Sentence> iterator() {
        return new Iterator<Sentence>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < sentenceList.size();
            }

            @Override
            public Sentence next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    return sentenceList.get(index++);
                }
            }
        };
    }
}
