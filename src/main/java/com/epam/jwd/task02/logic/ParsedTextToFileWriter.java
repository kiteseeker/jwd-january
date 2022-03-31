package com.epam.jwd.task02.logic;

import com.epam.jwd.task02.entity.Paragraph;
import com.epam.jwd.task02.entity.ParsedText;
import com.epam.jwd.task02.entity.Sentence;
import com.epam.jwd.task02.entity.SentenceElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writes parsed text object to a file with defined filename
 *
 * @see ParsedText
 */
public class ParsedTextToFileWriter {
    private static final Logger log = LogManager.getLogger();

    private ParsedTextToFileWriter() {
    }

    public static void writeTextToFile(ParsedText parsedText, String filename) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            int paragraphCount = 0;
            for (Paragraph paragraph : parsedText) {
                for (Sentence sentence : paragraph) {
                    for (SentenceElement element : sentence) {
                        writer.write(String.valueOf(element));
                    }
                }
                if (paragraphCount < parsedText.paragraphCount() - 1) {
                    writer.append('\n');
                    paragraphCount++;
                }
            }
        } catch (IOException e) {
            log.error(String.format("Unable to write file %s", filename), e);
        }
    }
}
