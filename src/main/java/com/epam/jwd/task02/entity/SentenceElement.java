package com.epam.jwd.task02.entity;

import com.epam.jwd.task02.entity.enums.SentenceElementType;

import java.util.Objects;

/**
 * The smallest element of a sentence: word, digit, punctuation of whitespace
 */
public abstract class SentenceElement {
    private final String element;

    SentenceElement(String sentenceElement) {
        this.element = sentenceElement;
    }

    public int elementLengths(SentenceElement element) {
        return element.toString().length();
    }

    public abstract SentenceElementType sentenceElementType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SentenceElement)) return false;
        SentenceElement that = (SentenceElement) o;
        return element.equals(that.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }

    @Override
    public String toString() {
        return element;
    }
}
