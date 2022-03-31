package com.epam.jwd.task02.entity;

import com.epam.jwd.task02.entity.enums.ParagraphType;

import java.util.List;

public class ParagraphCode extends Paragraph {
    public ParagraphCode(List<Sentence> paragraph) {
        super(paragraph);
    }

    @Override
    public ParagraphType paragraphType() {
        return ParagraphType.CODE;
    }
}
