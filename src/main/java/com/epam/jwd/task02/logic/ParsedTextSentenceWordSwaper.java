package com.epam.jwd.task02.logic;

import com.epam.jwd.task02.entity.Paragraph;
import com.epam.jwd.task02.entity.ParsedText;
import com.epam.jwd.task02.entity.Sentence;
import com.epam.jwd.task02.entity.SentenceElement;
import com.epam.jwd.task02.entity.enums.ParagraphType;
import com.epam.jwd.task02.entity.enums.SentenceElementType;

/**
 * Swaps first and last words in every sentence being a part of "regular text" and "title" paragraphs of the parsed
 * text. "Code" types paragraphs are ignored.
 *
 * @see Sentence
 * @see Paragraph
 * @see ParsedText
 */
public class ParsedTextSentenceWordSwaper {
    private final ParsedText parsedText;

    public ParsedTextSentenceWordSwaper(ParsedText parsedText) {
        this.parsedText = parsedText;
    }

    public void swapFirstAndLastWordsInSentence() {
        for (Paragraph paragraph : parsedText) {
            if (paragraph.paragraphType() != ParagraphType.CODE) {
                for (Sentence sentence : paragraph) {
                    int firstWordIndex = getFirstWordIndex(sentence);
                    int lastWordIndex = getLastWordIndex(sentence);
                    SentenceElement tempElement = sentence.getElement(firstWordIndex);
                    sentence.replaceElement(firstWordIndex, sentence.getElement(lastWordIndex));
                    sentence.replaceElement(lastWordIndex, tempElement);
                }
            }
        }
    }

    private int getFirstWordIndex(Sentence sentence) {
        int firstWordIndex = 0;
        for (int i = 0; i < sentence.getSentenceSize() - 1; i++) {
            if (sentence.getElement(i).sentenceElementType() == SentenceElementType.WORD) {
                firstWordIndex = i;
                break;
            }
        }
        return firstWordIndex;
    }

    private int getLastWordIndex(Sentence sentence) {
        int lastWordIndex = 0;
        for (int i = sentence.getSentenceSize() - 1; i >= 0; i--) {
            if (sentence.getElement(i).sentenceElementType() == SentenceElementType.WORD) {
                lastWordIndex = i;
                break;
            }
        }
        return lastWordIndex;
    }
}
