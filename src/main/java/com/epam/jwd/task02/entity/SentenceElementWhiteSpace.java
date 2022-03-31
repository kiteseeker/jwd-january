package com.epam.jwd.task02.entity;

import com.epam.jwd.task02.entity.enums.SentenceElementType;

public class SentenceElementWhiteSpace extends SentenceElement {
    public SentenceElementWhiteSpace(String sentenceElement) {
        super(sentenceElement);
    }

    @Override
    public SentenceElementType sentenceElementType() {
        return SentenceElementType.WHITESPACE;
    }
}
