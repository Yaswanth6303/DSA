package logicBuilding;

import fundamentals.HelperMethods;

import java.util.ArrayList;
import java.util.List;

public class IntersectionArray_5 {
    /**
     * Time Complexity -> O(n * m)
     * Space Complexity -> O(n)
     */
    public int[] intersectionArrayBrute(int[] nums1, int[] nums2) {
        List<Integer> intersectionList = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] visited = new int[n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j] && visited[j] != 1) {
                    intersectionList.add(nums1[i]);
                    visited[j] = 1;
                    break;
                } else if (nums2[j] > nums1[i]) {
                    break;
                }
            }
        }

        int[] intersectionArray = new int[intersectionList.size()];
        for (int i = 0; i < intersectionList.size(); i++) {
            intersectionArray[i] = intersectionList.get(i);
        }

        return intersectionArray;
    }
    /**
     * Time Complexity -> O(m + n)
     * Space Complexity -> O(1)
     */
    public int[] intersectionArrayOptimal(int[] nums1, int[] nums2) {
        List<Integer> intersectionList = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                intersectionList.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] intersectionArray = new int[intersectionList.size()];
        for (int k = 0; k < intersectionList.size(); k++) {
            intersectionArray[k] = intersectionList.get(k);
        }

        return intersectionArray;
    }
    public static void main(String[] args) {
        IntersectionArray_5 intersectionArray5 = new IntersectionArray_5();
        int[] nums1 = {1, 2, 2, 3, 3, 4, 5, 6};
        int[] nums2 = {2, 3, 3, 5, 6, 6, 7};

        int[] intersectionArrayBrute = intersectionArray5.intersectionArrayBrute(nums1, nums2);
        System.out.print("Intersection Array Brute: ");
        HelperMethods.printArray(intersectionArrayBrute);

        int[] intersectionArrayOptimal = intersectionArray5.intersectionArrayOptimal(nums1, nums2);
        System.out.print("Intersection Array Optimal: ");
        HelperMethods.printArray(intersectionArrayOptimal);
    }
}
