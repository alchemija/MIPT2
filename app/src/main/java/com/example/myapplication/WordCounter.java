package com.example.myapplication;

public class WordCounter {
    public static int countWords(String text) {
        String[] words = text.split("[\\s,\\.]");
        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public static int countCharacters(String text) {
        return text.length();
    }

    public static int countPunctuation(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.getType(text.charAt(i)) == Character.DASH_PUNCTUATION
                    || Character.getType(text.charAt(i)) == Character.START_PUNCTUATION
                    || Character.getType(text.charAt(i)) == Character.END_PUNCTUATION
                    || Character.getType(text.charAt(i)) == Character.CONNECTOR_PUNCTUATION
                    || Character.getType(text.charAt(i)) == Character.OTHER_PUNCTUATION) {
                count++;
            }
        }
        return count;
    }
}
