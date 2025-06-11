package logicBuilding;

public class MissingNumber_3 {
    /**
     * Time Complexity -> O(n^2)
     * Space Complexity -> O(1)
     */
    public int missingNumberBrute(int[] nums) {
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            int flag = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) return i;
        }

        return -1;
    }
    /**
     * Time Complexity -> O(n) + O(n) = O(2n)
     * Space Complexity -> O(n)
     */
    public int missingNumberBetter(int[] nums) {
        int n = nums.length;
        int[] frequencyArray = new int[n + 1];

        for (int num : nums) {
            frequencyArray[num]++;
        }

        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] == 0) {
                return i;
            }
        }

        return -1;
    }
    /**
     * Time Complexity -> O(n)
     * Space Complexity -> O(1)
     */
    public int missingNumberOptimal_1(int[] nums) {
        int n = nums.length;

        int sum1 = n * (n + 1) / 2;
        int sum2 = 0;

        for (int i = 0; i < n; i++) {
            sum2 += nums[i];
        }

        return sum1 - sum2;
    }
    /**
     * Time Complexity -> O(n)
     * Space Complexity -> O(1)
     */
    public int missingNumberOptimal_2(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;

        for(int i = 0; i < nums.length; i++) {
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ nums[i];
        }

        return xor1 ^ xor2;
    }
    public static void main(String[] args) {
        MissingNumber_3 missingNumber3 = new MissingNumber_3();
        int[] nums = {1, 2, 4, 5};

        int missingNumberBrute = missingNumber3.missingNumberBrute(nums);
        System.out.println("Missing Number Brute: " + missingNumberBrute);

        int missingNumberBetter = missingNumber3.missingNumberBetter(nums.clone());
        System.out.println("Missing Number Better: " + missingNumberBetter);

        int missingNumberOptimal_1 = missingNumber3.missingNumberOptimal_1(nums.clone());
        System.out.println("Missing Number Optimal_1: " + missingNumberOptimal_1);

        int missingNumberOptimal_2 = missingNumber3.missingNumberOptimal_2(nums.clone());
        System.out.println("Missing Number Optimal_2: " + missingNumberOptimal_2);
    }
}
