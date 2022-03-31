package com.epam.jwd.task02.entity;

import com.epam.jwd.task02.entity.enums.ParagraphType;

import java.util.List;

public class ParagraphTitle extends Paragraph {
    public ParagraphTitle(List<Sentence> paragraph) {
        super(paragraph);
    }

    @Override
    public ParagraphType paragraphType() {
        return ParagraphType.TITLE;
    }
}
