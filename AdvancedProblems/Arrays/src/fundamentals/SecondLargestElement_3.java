package fundamentals;

import java.util.Arrays;

public class SecondLargestElement_3 {
    /**
     * Time Complexity -> O(n * log n)
     * Space Complexity -> O(1)
     */
    public int secondLargestElementBrute(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int largestElement = nums[n - 1];
        int secondLargestElement = -1;

        for(int i = n - 2; i >= 0; i--) {
            if (nums[i] != largestElement) {
                secondLargestElement = nums[i];
                break;
            }
        }

        return secondLargestElement;
    }
    /**
     * Time Complexity -> O(n) + O(n) = O(2n)
     * Space Complexity -> O(1)
     */
    public int secondLargestElementBetter(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return -1;
        }

        int largestElement = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] > largestElement) {
                largestElement = nums[i];
            }
        }

        for(int i = 0; i < n; i++) {
            if (nums[i] > secondLargest && nums[i] != largestElement) {
                secondLargest = nums[i];
            }
        }

        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
    /**
     * Time Complexity -> O(n)
     * Space Complexity -> O(1)
     */
    public int secondLargestElementOptimal(int[] nums) {
        int n = nums.length;

        int largestElement = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] > largestElement) {
                secondLargest = largestElement;
                largestElement = nums[i];
            } else if (nums[i] > secondLargest && nums[i] != largestElement) {
                secondLargest = nums[i];
            }
        }

        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
    public static void main(String[] args) {
        SecondLargestElement_3 secondLargestElement = new SecondLargestElement_3();
        int[] nums = {8, 8, 7, 6, 5};

        int secondLargestElementBrute = secondLargestElement.secondLargestElementBrute(nums);
        System.out.print("Second Largest Element(Brute): ");
        System.out.println(secondLargestElementBrute);

        int secondLargestElementBetter = secondLargestElement.secondLargestElementBetter(nums.clone());
        System.out.print("Second Largest Element(Better): ");
        System.out.println(secondLargestElementBetter);

        int secondLargestElementOptimal = secondLargestElement.secondLargestElementOptimal(nums.clone());
        System.out.print("Second Largest Element(Optimal): ");
        System.out.println(secondLargestElementOptimal);
    }
}
