class Solution {
    /**
     * Checks if a given integer is a palindrome.
     * Negative numbers are not considered palindromes.
     *
     * @param x the integer to check.
     * @return true if x is a palindrome, false otherwise.
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false; // Negative numbers are not palindromes
        }
        return isPalindromeArray(convertToArray(x));
    }

    /**
     * Converts an integer into an array of its digits.
     *
     * @param num the integer to convert.
     * @return an array of digits representing the given integer.
     */
    private static int[] convertToArray(int num) {
        int length = getArrayLength(num); // Determine the length of the array needed
        int[] finalArray = new int[length];
        int index = 0;
        while (num != 0) {
            finalArray[index++] = num % 10; // Extract each digit and store in the array
            num /= 10;
        }
        return finalArray;
    }

    /**
     * Calculates the number of digits in an integer.
     *
     * @param num the integer whose length is to be calculated.
     * @return the number of digits in the integer.
     */
    private static int getArrayLength(int num) {
        int length = 0;
        do {
            num /= 10; // Divide by 10 to strip off each digit
            length++;
        } while (num != 0);
        return length;
    }

    /**
     * Checks if an array of integers represents a palindrome.
     *
     * @param array the array of integers to check.
     * @return true if the array represents a palindrome, false otherwise.
     */
    private static boolean isPalindromeArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] != array[end]) {
                return false; // If elements at mirrored positions don't match, it's not a palindrome
            }
            start++;
            end--;
        }
        return true; // The array is a palindrome if all mirrored elements match
    }
}
