public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        long result = 0;
        while (longDividend >= longDivisor)
        {
            longDividend -= longDivisor;
            result++;
        }
        return negative ? -(int) result : (int) result;
    }
}
