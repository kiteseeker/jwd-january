package com.epam.jwd.task02.entity;

import com.epam.jwd.task02.entity.enums.SentenceElementType;

public class SentenceElementWord extends SentenceElement {

    public SentenceElementWord(String element) {
        super(element);
    }

    @Override
    public SentenceElementType sentenceElementType() {
        return SentenceElementType.WORD;
    }
}
