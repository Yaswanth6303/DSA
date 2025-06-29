package onanswers;

public class NthRoot_2 {
    private int power(int a, int b) {
        long result = 1; // Use long to prevent overflow

        while (b > 0) {
            // Check if result * a will overflow int range
            if (result > Integer.MAX_VALUE / a) return Integer.MIN_VALUE;
            result *= a;
            b--;
        }

        return (int) result;
    }
    /**
     * Time Complexity: O(M * N)
     * Space Complexity: O(1)
     */
    public int nthRootBrute(int n, int m) {
        for (int i = 1; i <= m; i++) {
            int value = power(i, n);

            if (value == m) {
                return i;
            } else if (value == Integer.MIN_VALUE || value > m) {
                // If overflow or value exceeds m, stop searching
                break;
            }
        }

        return -1; // No such integer root found
    }
    /**
     * Time Complexity: O(log(M) * N)
     * Space Complexity: O(1)
     */
    public int nthRootOptimal1(int n, int m) {
        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int powerValue = power(mid, n);

            if (powerValue == m) {
                return mid;
            } else if (powerValue > m || powerValue < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public int nthRootOptimal2(int n, int m) {
        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = power(mid, n);

            if (value == m) {
                return mid;
            }

            if (value == Integer.MIN_VALUE || value > m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        NthRoot_2 nthRoot2 = new NthRoot_2();
        int N = 3;
        int M = 27;

        System.out.print("NthRoot Value(Brute): ");
        int nthRootValueBrute = nthRoot2.nthRootBrute(N, M);
        System.out.println(nthRootValueBrute);

        System.out.print("NthRoot Value(Optimal1): ");
        int nthRootValueOptimal1 = nthRoot2.nthRootOptimal1(N, M);
        System.out.println(nthRootValueOptimal1);

        System.out.print("NthRoot Value(Optimal2): ");
        int nthRootValueOptimal2 = nthRoot2.nthRootOptimal2(N, M);
        System.out.println(nthRootValueOptimal2);
    }
}
