
package com.example.wordcountapp;

public class counter {
    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }


        String[] words = text.split("[ ,.]+");
        int wordCount = 0;

        for (String word : words) {

            if (!word.trim().isEmpty()) {
                wordCount++;
            }
        }

        return wordCount;
    }

    public static int countCharacters(String text) {
        if (text == null) {
            return 0;
        }

        return text.length();
    }
}



