package com.epam.jwd.task02.logic;

import com.epam.jwd.task02.entity.Paragraph;
import com.epam.jwd.task02.entity.ParsedText;
import com.epam.jwd.task02.entity.Sentence;
import com.epam.jwd.task02.entity.SentenceElement;
import com.epam.jwd.task02.entity.enums.SentenceElementType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Retrieves words (sentence element, specified as word) from the parsed text into single arrayList.
 * <p>Sorts words in list alphabetically, ignoring case. Words with the same first letter are arranged to single lines
 * <p>Writes arrayList of words into a file with defined filename
 *
 * @see ParsedText
 * @see Sentence
 * @see SentenceElement
 */
public class ParsedTextWordSorter {
    private static final Logger log = LogManager.getLogger();
    private final ParsedText parsedText;

    public ParsedTextWordSorter(ParsedText parsedText) {
        this.parsedText = parsedText;
    }

    public void sortAndWriteWords(String filename) {
        List<String> textWordList = getWordsFromParsedText();
        textWordList.sort(String::compareToIgnoreCase);
        char letter = 'a';
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String word : textWordList) {
                char wordFirstLetter = Character.toLowerCase(word.charAt(0));
                if (letter != wordFirstLetter) {
                    writer.newLine();
                    letter = wordFirstLetter;
                }
                writer.write(word);
                writer.append(" ");
            }
        } catch (IOException e) {
            log.error(String.format("Unable to write file %s", filename), e);
        }
    }

    private List<String> getWordsFromParsedText() {
        List<String> textWordList = new ArrayList<>();
        for (Paragraph paragraph : parsedText) {
            for (Sentence sentence : paragraph) {
                for (SentenceElement element : sentence) {
                    if (element.sentenceElementType() == SentenceElementType.WORD) {
                        textWordList.add(element.toString());
                    }
                }
            }
        }
        return textWordList;
    }
}
