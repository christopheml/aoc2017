package day1;

public final class InverseCaptcha {

    private InverseCaptcha() {
    }

    public static int compute(String captcha) {
        int total = 0;

        for (int i = 0; i < captcha.length(); i++) {
            char current = captcha.charAt(i);
            char next = captcha.charAt(nextPosition(captcha, i));
            if (current == next) {
                total += Character.getNumericValue(current);
            }
        }

        return total;
    }

    /**
     * Returns the position next to the given one in the given captcha.
     *
     * This wraps around the end of the string, so nextPosition(captcha, captcha.size() - 1) == 0.
     */
    private static int nextPosition(String captcha, int i) {
        return (i + 1) % captcha.length();
    }

}
