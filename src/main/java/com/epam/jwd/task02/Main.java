package com.epam.jwd.task02;

import com.epam.jwd.task02.entity.ParsedText;
import com.epam.jwd.task02.logic.ParsedTextSentenceWordSwaper;
import com.epam.jwd.task02.logic.ParsedTextToFileWriter;
import com.epam.jwd.task02.logic.ParsedTextWordRemover;
import com.epam.jwd.task02.logic.ParsedTextWordSorter;
import com.epam.jwd.task02.parser.FileToTextLinesParser;
import com.epam.jwd.task02.parser.TextLinesParser;

public class Main {
    public static void main(String[] args) {

        FileToTextLinesParser textToLines = new FileToTextLinesParser("InputFile");
        textToLines.textLinesFromInputFile();

        TextLinesParser texLinesTotParagraphs = new TextLinesParser(textToLines);
        ParsedText parsedText = texLinesTotParagraphs.parseTextLines();

        // Restore original text.
        ParsedTextToFileWriter.writeTextToFile(parsedText, "OutputFile");

        // Task 5. Swap first and last words in every sentence. Sentence lengths should not be changed
        ParsedTextSentenceWordSwaper wordSwaper = new ParsedTextSentenceWordSwaper(parsedText);
        wordSwaper.swapFirstAndLastWordsInSentence();
        ParsedTextToFileWriter.writeTextToFile(parsedText, "OutputAfterWordSwaper");

        // Task 6. Write all words from the text alphabetically. Use different lines for thw words with the different
        // first letter.
        ParsedTextWordSorter wordsSorter = new ParsedTextWordSorter(parsedText);
        wordsSorter.sortAndWriteWords("OutputAfterWordSorter");

        // Task 12. Remove any dedicated length word from the text, that begins with consonant letter
        ParsedTextWordRemover wordRemover = new ParsedTextWordRemover(parsedText);
        wordRemover.removeWords(4);
        ParsedTextToFileWriter.writeTextToFile(parsedText, "OutputAfterWordRemover");
    }
}
