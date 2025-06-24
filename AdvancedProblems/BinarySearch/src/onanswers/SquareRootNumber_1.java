package onanswers;

public class SquareRootNumber_1 {
    /**
     * Time Complexity: O(sqrt(n))
     * Space Complexity: O(1)
     */
    public long floorSqrtBruteM1(long n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            if (i * i <= n) result = i;
            else break;;
        }

        return result;
    }
    /**
     * Time Complexity: O(sqrt(n))
     * Space Complexity: O(1)
     */
    public long floorSqrtBruteM2(long n) {
        if (n == 0 || n == 1) return n;

        for (long i = 1; i <= n / i; i++) {
            long value = i * i;
            if (value == n) {
                return i;
            } else if ((i + 1) > n / (i + 1)) { // Checking (i + 1)^2 > n
                return i;
            }
        }
        return -1;
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

        System.out.print("Square root of the number is (BruteM1): ");
        long sqrtNumberBruteM1 = solver.floorSqrtBruteM1(number);
        System.out.println(sqrtNumberBruteM1);

        System.out.print("Square root of the number is (BruteM2): ");
        long sqrtNumberBruteM2 = solver.floorSqrtBruteM2(number);
        System.out.println(sqrtNumberBruteM2);

        System.out.print("Square root of the number is(Optimal): ");
        long sqrtNumberOptimal = solver.floorSqrtOptimal(number);
        System.out.println(sqrtNumberOptimal);
    }
}
