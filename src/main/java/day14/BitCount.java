package day14;

import java.util.HashMap;
import java.util.Map;

public class BitCount {

    private final Map<Character, Integer> bitsPerCharacter = new HashMap<>();

    public BitCount() {
        bitsPerCharacter.put('0', 0);
        bitsPerCharacter.put('1', 1);
        bitsPerCharacter.put('2', 1);
        bitsPerCharacter.put('3', 2);
        bitsPerCharacter.put('4', 1);
        bitsPerCharacter.put('5', 2);
        bitsPerCharacter.put('6', 2);
        bitsPerCharacter.put('7', 3);
        bitsPerCharacter.put('8', 1);
        bitsPerCharacter.put('9', 2);
        bitsPerCharacter.put('a', 2);
        bitsPerCharacter.put('b', 3);
        bitsPerCharacter.put('c', 2);
        bitsPerCharacter.put('d', 3);
        bitsPerCharacter.put('e', 3);
        bitsPerCharacter.put('f', 4);
    }

    public int count(char c) {
        return bitsPerCharacter.get(c);
    }

    public int count(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += count(s.charAt(i));
        }
        return count;
    }

}
