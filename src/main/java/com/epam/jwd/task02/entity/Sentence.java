package com.epam.jwd.task02.entity;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * An arrayList, composed of different types sentence elements
 *
 * @see SentenceElement
 */
public class Sentence implements Iterable<SentenceElement> {
    private final List<SentenceElement> sentenceElementList;

    public Sentence(List<SentenceElement> sentence) {
        this.sentenceElementList = sentence;
    }

    public SentenceElement getElement(int i) {
        return sentenceElementList.get(i);
    }

    public int getSentenceSize() {
        return sentenceElementList.size();
    }

    public void replaceElement(int i, SentenceElement element) {
        sentenceElementList.add(i, element);
        sentenceElementList.remove(i + 1);
    }

    public void removeElement(SentenceElement element) {
        sentenceElementList.remove(element);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;
        Sentence that = (Sentence) o;
        return sentenceElementList.equals(that.sentenceElementList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentenceElementList);
    }

    @Override
    public String toString() {
        return sentenceElementList.toString();
    }

    @Override
    public Iterator<SentenceElement> iterator() {
        return new Iterator<SentenceElement>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < sentenceElementList.size();
            }

            @Override
            public SentenceElement next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    return sentenceElementList.get(index++);
                }
            }
        };
    }
}
