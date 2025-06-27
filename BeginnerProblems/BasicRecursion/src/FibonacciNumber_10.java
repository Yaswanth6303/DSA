public class FibonacciNumber_10 {
    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void main(String[] args) {
        FibonacciNumber_10 solution = new FibonacciNumber_10();
        int n = 5;
        System.out.println("Fibonacci number at position " + n + " is " + solution.fibonacci(n));
    }
}
