package faqs;

public class BookAllocation_2 {
    public int[] findMaxAndSum(int[] nums) {
        int n = nums.length;
        int maxValue = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }

        return new int[]{maxValue, sum};
    }
    public boolean countStudents(int[] books, int pages, int m) {
        int n = books.length;

        int students = 1;
        int pagesToStudent = 0;

        for (int i = 0; i < n; i++) {
            if (pagesToStudent + books[i] <= pages) {
                pagesToStudent += books[i];
            } else {
                students++;
                pagesToStudent = books[i];
                if (students > m) {
                    return false;
                }
            }
        }

        return true;
    }
    /**
     * Time Complexity: O(N * (sum-max))
     * Space Complexity: O(1)
     */
    public int findPagesBrute(int[] books, int students) {
        int n = books.length;
        if (students > n) return -1;
        int[] sumAndMax = findMaxAndSum(books);
        int maxValue = sumAndMax[0];
        int sum = sumAndMax[1];

        for (int pages = maxValue; pages <= sum; pages++) {
            if (countStudents(books, pages, students)) {
                return pages;
            }
        }

        return maxValue;
    }
    /**
     * Time Complexity: O(N * log(sum-max))
     * Space Complexity: O(1)
     */
    public int findPagesOptimal(int[] books, int students) {
        int n = books.length;
        if (students > n) return -1;

        int[] sumAndMax = findMaxAndSum(books);
        int low = sumAndMax[0];
        int high = sumAndMax[1];
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (countStudents(books, mid, students)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
     static void main(String[] args) {
        BookAllocation_2 solver = new BookAllocation_2();
        int[] books = {25, 46, 28, 49, 24};
        int students = 4;

        System.out.print("Minimum number of pages (Brute Force): ");
        int resultBrute = solver.findPagesBrute(books, students);
        System.out.println(resultBrute);

        System.out.print("Minimum number of pages (Optimal): ");
        int resultOptimal = solver.findPagesOptimal(books, students);
        System.out.println(resultOptimal);
    }
}
