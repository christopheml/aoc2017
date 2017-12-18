package day16;

import java.util.Arrays;

public class Line {

    private static final String PROGRAMS = "abcdefghijklmnop";

    private final char[] programs;

    public Line(int size) {
        if (size > PROGRAMS.length()) {
            throw new IllegalArgumentException();
        }

        programs = PROGRAMS.substring(0, size).toCharArray();
    }

    public void spin(int offset) {
        int leftChunkSize = programs.length - (offset % programs.length);
        int rightChunkSize = offset % programs.length;

        if (leftChunkSize > rightChunkSize) {
            // Saving the biggest chunk to make room for in-place array copy
            char[] leftChunk = Arrays.copyOf(programs, leftChunkSize);
            // Copy of right chunk to the left of the array
            System.arraycopy(programs, leftChunkSize, programs, 0, rightChunkSize);
            // Copy of left chunk to the right of the array
            System.arraycopy(leftChunk, 0, programs, rightChunkSize, leftChunkSize);
        } else {
            // Saving the biggest chunk to make room for in-place array copy
            char[] rightChunk = new char[rightChunkSize];
            System.arraycopy(programs, leftChunkSize, rightChunk,0, rightChunkSize);
            // Copy of left chunk to the right of the array
            System.arraycopy(programs, 0, programs, rightChunkSize, leftChunkSize);
            // Copy of right chunk to the left of the array
            System.arraycopy(rightChunk, 0, programs, 0, rightChunkSize);
        }
    }

    public void swapPositions(int p1, int p2) {
        char temp = programs[p1];
        programs[p1] = programs[p2];
        programs[p2] = temp;
    }

    public void swapPrograms(char c1, char c2) {
        int p1 = indexOf(c1);
        int p2 = indexOf(c2);
        swapPositions(p1, p2);
    }

    private int indexOf(char c) {
        for (int i = 0; i < programs.length; ++i) {
            if (programs[i] == c) {
                return i;
            }
        }
        throw new IllegalStateException();
    }

    public boolean isInitialState() {
        return PROGRAMS.startsWith(toString());
    }

    @Override
    public String toString() {
        return new String(programs);
    }

}
