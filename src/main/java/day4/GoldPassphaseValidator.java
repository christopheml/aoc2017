package day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public class GoldPassphaseValidator {

    public boolean isValid(String passphrase) {
        String[] words = getSortedWords(passphrase);
        Set<String> wordSet = new HashSet<>(asList(words));
        return wordSet.size() == words.length;
    }

    private String[] getSortedWords(String passphrase) {
        String[] words = passphrase.split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = sortLetters(words[i]);
        }
        return words;
    }

    private String sortLetters(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
