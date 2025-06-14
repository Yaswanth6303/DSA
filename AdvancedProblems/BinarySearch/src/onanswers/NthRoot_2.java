package onanswers;

public class NthRoot_2 {
    private int power(int a, int b) {
        int res = 1;
        while (b > 0) {
            if (res > Integer.MAX_VALUE / a) return Integer.MAX_VALUE; // prevent overflow
            res *= a;
            b--;
        }
        return res;
    }
    /**
     * Time Complexity: O(M * N)
     * Space Complexity: O(1)
     */
    public int nthRootBrute(int N, int M) {
        for (int i = 1; i <= N; i++) {
            int powerValue = power(i, N);
            if (powerValue == M) {
                return i;
            } else if (powerValue > M) {
                break;
            }
        }

        return -1;
    }
    /**
     * Time Complexity: O(log(M) * N)
     * Space Complexity: O(1)
     */
    public int nthRootOptimal(int N, int M) {
        int low = 1;
        int high = M;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int powerValue = power(mid, N);

            if (powerValue == M) {
                return mid;
            } else if (powerValue > M || powerValue < 0) {
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

        System.out.print("NthRoot Value(Optimal): ");
        int nthRootValueOptimal = nthRoot2.nthRootOptimal(N, M);
        System.out.println(nthRootValueOptimal);
    }
}
