# jwd-january 2022, Minsk
# Task 1:

Defined hierarchy of gemstones in accordance with their chemical structure / origin / physical properties

Base abstract class Gemstone is extended by:

In accordance with generally accepted classifications, only 4 stones are called "precious" and can be divided into:

1. Precious Diamond Stones - contains only diamonds (pure carbon minerals) with a specific cut type.
2. Precious Color Stones - contains other precious stones (Ruby, Emerald and Sapphire) with a complex chemical structure
and color determine impurities.

In accordance with generally accepted classifications, all others jewelery gemstones are "semiprecious", and 
can be divided into:

3. Semiprecious Mineral stones - stones of mineral origin - nature silicates with color determine impurities.
4. Semiprecious Organic stones - stones of nature origin - produced by animals or plants.

In addition, all precious stones are transparent, semiprecious stones may show additional transparency options -
TRANSLUCENT, SEMITRANSLUCENT, OPAQUE

The creation of single abstract classes "preciousStone" and "semipreciousStone" is beside the point because no unique
properties (fields) that can be identified to show the differences between these two classes.

**********************************************************************************************************************
# Task 2:

Created an application, which allows parsing text from file with keeping the original structure.

The text initially transformed into ArrayList of paragraphs of different types: title, regular text and code block
using regular expressions.

Every title and code block paragraph is considered to be composed of a single sentence. Regular text paragraph is
split to normal sentences. Every paragraph is an ArrayList of sentences.

Every sentence is parsed into ArrayList of elements: word, digit, punctuation mark and whitespace.

Errors are logged by log4j2.

Parsed text could be completely restored and written to a new file.

An application also allows to:

 - Swap first and last words in every sentence. Sentence lengths should not be changed (task 5). 
   - note: code paragraphs are ignored.
 
 - Write all words from the text alphabetically. Use different lines for thw words with the different first
   letter (task 6).

 - Remove any dedicated length word from the text, that begins with consonant letter (task 12).

