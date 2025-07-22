public class TextProcessor {

    // Count words in a sentence
    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        String[] words = sentence.trim().split("\\s+"); // Split by one or more spaces
        return words.length;
    }

    // Replace specific words
    public static String replaceWord(String text, String oldWord, String newWord) {
        if (text == null) {
            return "";
        }
        return text.replace(oldWord, newWord); // Replace all occurrences
    }

    public static void main(String[] args) {
        String input = "Java is fun and Java is powerful";

        // Count words
        int wordCount = countWords(input);
        System.out.println("Word Count: " + wordCount);

        // Replace "Java" with "Programming"
        String replacedText = replaceWord(input, "Java", "Programming");
        System.out.println("After Replacement: " + replacedText);
    }
}
