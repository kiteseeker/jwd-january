package com.epam.jwd.task02.entity;

import com.epam.jwd.task02.entity.enums.SentenceElementType;

public class SentenceElementDigit extends SentenceElement {
    public SentenceElementDigit(String sentenceElement) {
        super(sentenceElement);
    }

    @Override
    public SentenceElementType sentenceElementType() {
        return SentenceElementType.DIGIT;
    }
}
