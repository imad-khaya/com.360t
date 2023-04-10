package com360t.playerexercise;

/**
 * The TestUsefulFunctions class provides a set of utility methods for string and number manipulation, in order to be used later in the JUnit Test
 */
public class TestUsefulFunctions {

    /**
     * Determines if the last character of the input string is a digit.
     *
     * @param str the input string
     * @return true if the last character of the string is a digit, false otherwise
     */
    public static boolean isLastDigit(String str){
        int len = str.length();
        return Character.isDigit(str.charAt(len-1));
    }

    /**
     * Extracts the last number in the input string.
     *
     * @param str the input string
     * @return the last number in the string, or 0 if there is no number at the end of the string
     */
    public static int getLastNum(String str){
        int len = str.length();
        if (len == 0) return 0;
        String lastNum ="";
        for (int i=len; i>0; i--){
            if (isLastDigit(str.substring(0,i))) lastNum = str.charAt(len-1) + lastNum;
        }
        return Integer.parseInt(lastNum);

    }

    /**
     * Returns the number of digits in the input integer. It should be noted, it can't be used for neg numbers. Just ignored it.
     * It can be used for negative number simply by using the absolute value of {@code n}instead of {@code n} itself ,but we don't need that now.
     *
     * @param n the input integer.
     * @return the number of digits in the integer.
     * @throws IllegalArgumentException if {@code n} is negative.
     */
    public static int getNumberOfDigits(int n){
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        return (n == 0) ? 1 : (int) (Math.log10(n) + 1);
    }
}
