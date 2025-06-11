package logicBuilding;

import fundamentals.HelperMethods;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionArray_4 {
    public int[] unionArrayBrute(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int value : nums1) {
            set.add(value);
        }

        for (int value : nums2) {
            set.add(value);
        }

        int index = 0;
        int[] unionArray = new int[set.size()];
        for (int num : set) {
            unionArray[index++] = num;
        }

        return unionArray;
    }
    public int[] unionArrayOptimal(int[] nums1, int[] nums2) {
        List<Integer> unionList = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums1[i]) {
                    unionList.add(nums1[i]);
                }
                i++;
            } else {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums2[j]) {
                    unionList.add(nums2[j]);
                }
                j++;
            }
        }

        while (i < n1) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums1[i]) {
                unionList.add(nums1[i]);
            }
            i++;
        }

        while (j < n2) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums2[j]) {
                unionList.add(nums2[j]);
            }
            j++;
        }

        int[] unionArray = new int[unionList.size()];
        for (int k = 0; k < unionList.size(); k++) {
            unionArray[k] = unionList.get(k);
        }

        return unionArray;
    }
    public static void main(String[] args) {
        UnionArray_4 unionArray4 = new UnionArray_4();
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {5, 6, 7, 8};

        int[] unionArrayBrute = unionArray4.unionArrayBrute(nums1, nums2);
        System.out.print("Union Array Brute: ");
        HelperMethods.printArray(unionArrayBrute);

        int[] unionArrayOptimal = unionArray4.unionArrayOptimal(nums1, nums2);
        System.out.print("Union Array Optimal: ");
        HelperMethods.printArray(unionArrayOptimal);
    }
}
