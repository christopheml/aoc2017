package day4;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public class PassphraseValidator {

    public boolean isValid(String passphrase) {
        String[] words = passphrase.split(" ");
        Set<String> wordSet = new HashSet<>(asList(words));
        return wordSet.size() == words.length;
    }

}
