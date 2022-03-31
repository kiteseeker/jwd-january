package com.epam.jwd.task02.entity;

import com.epam.jwd.task02.entity.enums.SentenceElementType;

public class SentenceElementPunctuationMark extends SentenceElement {

    public SentenceElementPunctuationMark(String sentenceElement) {
        super(sentenceElement);
    }

    @Override
    public SentenceElementType sentenceElementType() {
        return SentenceElementType.PUNCTUATION;
    }
}
