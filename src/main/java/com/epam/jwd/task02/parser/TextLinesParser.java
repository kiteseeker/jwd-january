package com.epam.jwd.task02.parser;

import com.epam.jwd.task02.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Creates {@link ParsedText} from <tt>ArrayList</tt>, obtained after {@link FileToTextLinesParser}
 * consists of different types paragraphs - titles, regular text and code blocks according to defined <tt>Pattern</tt>.
 * Parsed text is an <tt>ArrayList</tt> of <tt>Paragraph</tt>.
 * <p>Title and code paragraphs considered consisting of single sentence. Regular text paragraph is split into
 * sentences by ".". Each paragraph is an <tt>ArrayList</tt> of <tt>Sentence</tt>.
 * <p>Every single sentence is parsed to sentence elements - word, digit, punctuation, whitespace by
 * {@link StringToSentenceElementParser}. Each sentence is an <tt>ArrayList</tt> of <tt>SentenceElement</tt>.
 * <p>
 * @see FileToTextLinesParser
 * @see StringToSentenceElementParser
 * @see SentenceElement
 * @see Sentence
 * @see Paragraph
 * @see ParsedText
 */
public class TextLinesParser {
    private static final String REGEXP_TITLE_PARAGRAPH = "^[0-9]\\.(\\t*).+";
    private static final String REGEXP_REGULAR_TEXT_PARAGRAPH = "^(\\s+[A-Z]|[A-Z]).+[.:A-Za-z]$";
    private static final String REGEXP_REGULAR_SENTENCE = ".+([a-z0-9])$";
    private final FileToTextLinesParser textLines;
    private final ParsedText parsedText;

    public TextLinesParser(FileToTextLinesParser textLines) {
        this.textLines = textLines;
        this.parsedText = new ParsedText();
    }

    /**
     * Creates parsed text from arrayList of text lines
     *
     * @return parsed text - an arrayList of paragraphs, parsed on sentences, parsed on sentence elements
     */
    public ParsedText parseTextLines() {
        for (String textLine : textLines) {
            if (Pattern.matches(REGEXP_TITLE_PARAGRAPH, textLine)) {
                addTitleParagraph(textLine);
            } else if (Pattern.matches(REGEXP_REGULAR_TEXT_PARAGRAPH, textLine)) {
                addRegularTextParagraph(textLine);
            } else {
                addCodeParagraph(textLine);
            }
        }
        return parsedText;
    }

    /**
     * Adds paragraph of "code" type to parsed text. Specified paragraph type is a single sentence, parsed to
     * sentence elements.
     *
     * @param textLine sentence  <tt>String</tt>, defined as code paragraph by regexp
     */
    private void addCodeParagraph(String textLine) {
        StringToSentenceElementParser toElementParser = new StringToSentenceElementParser(textLine);
        Sentence sentence = new Sentence(toElementParser.parseStringToElements());
        List<Sentence> sentenceList = new ArrayList<>();
        sentenceList.add(sentence);
        Paragraph paragraph = new ParagraphCode(sentenceList);
        parsedText.addNewParagraph(paragraph);
    }

    /**
     * Adds paragraph of "regular text" type to parsed text. Specified paragraph type is split into sentences by ".",
     * each sentence parsed to sentence elements. In order not to miss dot marks, before parsing sentences
     * <code>String.concat(".")</code> method is used.
     *
     * @param textLine sentence(es) <tt>String</tt>, defined as regular text paragraph by regex
     */
    private void addRegularTextParagraph(String textLine) {
        List<Sentence> sentenceList = new ArrayList<>();
        String[] splitTextLines = textLine.split("\\.");
        for (String splitTextLine : splitTextLines) {
            if (Pattern.matches(REGEXP_REGULAR_SENTENCE, splitTextLine)) {
                splitTextLine = splitTextLine.concat(".");
            }
            StringToSentenceElementParser toElementParser = new StringToSentenceElementParser(splitTextLine);
            Sentence sentence = new Sentence(toElementParser.parseStringToElements());
            sentenceList.add(sentence);
        }
        Paragraph paragraph = new ParagraphRegularText(sentenceList);
        parsedText.addNewParagraph(paragraph);
    }

    /**
     * Adds paragraph of "title" type to parsed text. Specified paragraph type is a single sentence, parsed to
     * sentence elements.
     *
     * @param textLine sentence  <tt>String</tt>, defined as title paragraph by regexp
     */
    private void addTitleParagraph(String textLine) {
        StringToSentenceElementParser toElementParser = new StringToSentenceElementParser(textLine);
        Sentence sentence = new Sentence(toElementParser.parseStringToElements());
        List<Sentence> sentenceList = new ArrayList<>();
        sentenceList.add(sentence);
        Paragraph paragraph = new ParagraphTitle(sentenceList);
        parsedText.addNewParagraph(paragraph);
    }
}
