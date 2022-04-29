package com.epam.jwd.task02.logic;

import com.epam.jwd.task02.entity.Paragraph;
import com.epam.jwd.task02.entity.ParsedText;
import com.epam.jwd.task02.entity.Sentence;
import com.epam.jwd.task02.entity.SentenceElement;
import com.epam.jwd.task02.entity.enums.SentenceElementType;

import java.util.regex.Pattern;

/**
 * Removes any dedicated length word (sentence element, specified as word) from the parsed text, that begins
 * with consonant letter
 *
 * @see ParsedText
 * @see Sentence
 * @see SentenceElement
 */
public class ParsedTextWordRemover {
    private static final String REGEXP_VOWELS_FIRST = "^[aAeEiIoOuUyY].*";
    private final ParsedText parsedText;

    public ParsedTextWordRemover(ParsedText parsedText) {
        this.parsedText = parsedText;
    }

    public void removeWords(int wordLengths) {
        for (Paragraph paragraph : parsedText) {
            for (Sentence sentence : paragraph) {
                for (SentenceElement element : sentence) {
                    if (element.sentenceElementType() == SentenceElementType.WORD
                            && element.elementLengths(element) == wordLengths
                            && !Pattern.matches(REGEXP_VOWELS_FIRST, element.toString())) {
                        sentence.removeElement(element);
                    }
                }
            }
        }
    }
}
