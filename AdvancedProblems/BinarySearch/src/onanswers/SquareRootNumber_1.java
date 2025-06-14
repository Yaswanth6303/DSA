package onanswers;

public class SquareRootNumber_1 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public long floorSqrtBrute(long n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            if (i * i <= n) result = i;
            else break;;
        }

        return result;
    }
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public long floorSqrtOptimal(long n) {
        long low = 0;
        long high = n;
        long result = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid <= n) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        SquareRootNumber_1 solver = new SquareRootNumber_1();
        long number = 28;

        System.out.print("Square root of the number is(Brute): ");
        long sqrtNumberBrute = solver.floorSqrtBrute(number);
        System.out.println(sqrtNumberBrute);

        System.out.print("Square root of the number is(Optimal): ");
        long sqrtNumberOptimal = solver.floorSqrtOptimal(number);
        System.out.println(sqrtNumberOptimal);
    }
}
