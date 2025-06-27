public class FactorialNumber_2 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Note : For very large numbers, recursion can lead to a stack overflow due to too many nested function calls.
     */
    public long factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
    public static void main(String[] args) {
        FactorialNumber_2 solution = new FactorialNumber_2();
        int n = 5;
        System.out.println("Factorial of " + n + " is " + solution.factorial(n));
    }
}
