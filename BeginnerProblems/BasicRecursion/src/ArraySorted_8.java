import java.util.ArrayList;
import java.util.List;

public class ArraySorted_8 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isSorted(ArrayList<Integer> nums) {
        if (nums.size() <= 1) {
            return true;
        }

        return sort(nums, 0, 1);
    }
    public boolean sort(ArrayList<Integer> nums, int left, int right) {
        if (right >= nums.size()) return true;

        if (nums.get(left) > nums.get(right)) {
            return false;
        }

        return sort(nums, left + 1, right + 1);
    }
    public static void main(String[] args) {
        ArraySorted_8 solution = new ArraySorted_8();
        ArrayList<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        boolean result = solution.isSorted(nums);
        System.out.println(result ? "Array is sorted" : "Array is not sorted");
    }
}
