package com.epam.jwd.task02.parser;

import com.epam.jwd.task02.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates an <tt>ArrayList</tt> of sentence elements from defined <tt>String</tt>
 *
 * @see SentenceElement
 */
public class StringToSentenceElementParser {
    private final String text;

    public StringToSentenceElementParser(String text) {
        this.text = text;
    }

    public List<SentenceElement> parseStringToElements() {
        List<SentenceElement> sentenceElementList = new ArrayList<>();
        String word = "";
        for (char textChar : text.toCharArray()) {
            if (Character.isLetter(textChar)) {
                word = word.concat(String.valueOf(textChar));
            } else if (Character.isWhitespace(textChar)) {
                word = addWhitespace(sentenceElementList, word, textChar);
            } else if (Character.isDigit(textChar)) {
                word = addDigit(sentenceElementList, word, textChar);
            } else {
                word = addPunctuation(sentenceElementList, word, textChar);
            }
        }
        if (word.length() != 0) {
            sentenceElementList.add(new SentenceElementWord(word));
        }
        return sentenceElementList;
    }


    private String addPunctuation(List<SentenceElement> sentenceElementList, String word, char textChar) {
        if (word.length() != 0) {
            sentenceElementList.add(new SentenceElementWord(word));
            sentenceElementList.add(new SentenceElementPunctuationMark(String.valueOf(textChar)));
            word = "";
        } else {
            sentenceElementList.add(new SentenceElementPunctuationMark(String.valueOf(textChar)));
        }
        return word;
    }

    private String addDigit(List<SentenceElement> sentenceElementList, String word, char textChar) {
        if (word.length() != 0) {
            sentenceElementList.add(new SentenceElementWord(word));
            sentenceElementList.add(new SentenceElementDigit(String.valueOf(textChar)));
            word = "";
        } else {
            sentenceElementList.add(new SentenceElementDigit(String.valueOf(textChar)));
        }
        return word;
    }

    private String addWhitespace(List<SentenceElement> sentenceElementList, String word, char textChar) {
        if (word.length() != 0) {
            sentenceElementList.add(new SentenceElementWord(word));
            sentenceElementList.add(new SentenceElementWhiteSpace(String.valueOf(textChar)));
            word = "";
        } else {
            sentenceElementList.add(new SentenceElementWhiteSpace(String.valueOf(textChar)));
        }
        return word;
    }
}
