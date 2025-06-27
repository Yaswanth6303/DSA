package implementationProblems;

public class PowXN_1 {
    private double fastPow(double x, long n) {
        double result = 1.0;
        for(int i = 1; i <= n; i++) {
            result *= x;
        }
        return result;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public double myPowBrute(double x, int n) {
        long N = n;  // Use long to safely handle Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -1 * N;
        }
        return fastPow(x, N);
    }
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public double myPowOptimalIterative(double x, int n) {
        long N = n;
        double result = 1.0;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        while (N > 0) {
            if (N % 2 == 1) {
                result *= x;
            }
            x *= x;
            N /= 2;
        }

        return result;
    }
    public double power(double x, long n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;

        if (n % 2 == 1) {
            return x * power(x, n - 1);
        } else {
            return power(x * x, n / 2);
        }
    }
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     */
    public double myPowOptimalRecursive(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return power(x, N);
    }
    public static void main(String[] args) {
        PowXN_1 solution = new PowXN_1();
        double x = 2.0000;
        int n = 10;
        System.out.println("Brute Solution: " + solution.myPowBrute(x, n));
        System.out.println("Optimal Solution Iterative: " + solution.myPowOptimalIterative(x, n));
        System.out.println("Optimal Solution Recursive: " + solution.myPowOptimalRecursive(x, n));
    }
}
