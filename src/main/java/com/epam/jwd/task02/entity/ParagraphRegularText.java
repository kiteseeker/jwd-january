package com.epam.jwd.task02.entity;

import com.epam.jwd.task02.entity.enums.ParagraphType;

import java.util.List;

public class ParagraphRegularText extends Paragraph {
    public ParagraphRegularText(List<Sentence> paragraph) {
        super(paragraph);
    }

    @Override
    public ParagraphType paragraphType() {
        return ParagraphType.MAIN_TEXT;
    }
}
