package logicBuilding;

import java.util.ArrayList;
import java.util.List;

public class HelperMethods {
    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void printList(ArrayList<Integer> list) {
        System.out.print("[");
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void printList(List<Integer> list) {
        System.out.print("[");
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void printListOfLists(List<List<Integer>> listOfLists) {
        for (List<Integer> innerList : listOfLists) {
            for (int num : innerList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
