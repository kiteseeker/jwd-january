package com.epam.jwd.task02.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Creates an <tt>ArrayList</tt> of text lines from defined file by splitting text with nextLine() method of Scanner
 */
public class FileToTextLinesParser implements Iterable<String> {
    private static final Logger logger = LogManager.getLogger(FileToTextLinesParser.class);
    private final String fileName;
    private final List<String> textLines;

    public FileToTextLinesParser(String fileName) {
        this.fileName = fileName;
        this.textLines = new ArrayList<>();
    }

    /**
     * @throws FileNotFoundException if the specified file cannot be found
     */
    public void textLinesFromInputFile() {
        try (Scanner inputFileReader = new Scanner(new FileReader(fileName))) {
            while (inputFileReader.hasNext()) {
                textLines.add(inputFileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            logger.error(String.format("File %s not found", fileName), e);
        }
    }

    @Override
    public String toString() {
        return textLines.toString();
    }

    @Override
    public Iterator<String> iterator() {
        return textLines.iterator();
    }
}
