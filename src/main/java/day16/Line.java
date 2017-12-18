package day16;

class Line {

    private static final String PROGRAMS = "abcdefghijklmnop";

    private String programs;

    public Line(int size) {
        if (size > PROGRAMS.length()) {
            throw new IllegalArgumentException();
        }

        programs = PROGRAMS.substring(0, size);
    }

    public void spin(int offset) {
        int leftChuckSize = programs.length() - (offset % programs.length());

        String leftChuck = programs.substring(0, leftChuckSize);
        String rightChuck = programs.substring(leftChuckSize);

        programs = rightChuck + leftChuck;
    }

    public void swapPositions(int p1, int p2) {
        char[] chars = programs.toCharArray();
        char temp = chars[p1];
        chars[p1] = chars[p2];
        chars[p2] = temp;

        programs = new String(chars);
    }

    public void swapPrograms(char c1, char c2) {
        int p1 = programs.indexOf(c1);
        int p2 = programs.indexOf(c2);
        swapPositions(p1, p2);
    }

    @Override
    public String toString() {
        return programs;
    }

}
