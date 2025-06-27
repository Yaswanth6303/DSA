public class SumOfNNaturalNumbers_1 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int nNumbersSum(int n) {
        if (n == 0) return 0;
        return n + nNumbersSum(n - 1);
    }
    public static void main(String[] args) {
        SumOfNNaturalNumbers_1 solution = new SumOfNNaturalNumbers_1();
        int n = 10;
        System.out.println("Sum of first " + n + " numbers is " + solution.nNumbersSum(n));
    }
}
