package faqHard;

public class MaxProductSubArray_6 {
    public int maxProductBrute(int[] nums) {
        int n = nums.length;
        int maxProduct = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int product = 1;
                for (int k = i; k <= j; k++) {
                    product *= nums[k];
                }
                maxProduct = Math.max(product, maxProduct);
            }
        }

        return maxProduct;
    }
    public int maxProductBetter(int[] nums) {
        int n = nums.length;
        int maxProduct = 0;

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
            }
            maxProduct = Math.max(product, maxProduct);
        }

        return maxProduct;
    }
    public int maxProductOptimal(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {
            // When 0 is in array product becomes 0 make it 1;
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= nums[i];
            suffix *= nums[n - 1 - i];

            maxProduct = Math.max(prefix, suffix);
        }

        return maxProduct;
    }
    public static void main(String[] args) {
        MaxProductSubArray_6 solver = new MaxProductSubArray_6();
        int[] nums = {4, 5, 3, 7, 1, 2};
        System.out.print("Max Product Brute: ");
        int maxProductBrute = solver.maxProductBrute(nums);
        System.out.println(maxProductBrute);

        System.out.print("Max Product Better: ");
        int maxProductBetter = solver.maxProductBetter(nums.clone());
        System.out.println(maxProductBetter);

        System.out.print("Max Product Optimal: ");
        int maxProductOptimal = solver.maxProductBetter(nums.clone());
        System.out.println(maxProductOptimal);
    }
}
