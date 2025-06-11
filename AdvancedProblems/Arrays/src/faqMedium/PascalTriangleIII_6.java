package faqMedium;

import fundamentals.HelperMethods;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleIII_6 {
    public List<List<Integer>> pascalTriangleBrute(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int r = 1; r <= n; r++) {
            List<Integer> pascalRow = new ArrayList<>();
            for (int c = 1; c <= r; c++) {
                pascalRow.add(PascalTriangleI_4.nCr(r - 1, c - 1));
            }
            pascalTriangle.add(pascalRow);
        }

        return pascalTriangle;
    }
    public List<Integer> generateRow(int row) {
        List<Integer> pascalList = new ArrayList<>();
        long result = 1;
        pascalList.add((int) result);

        for (int col = 1; col < row; col++) {
            result = result * (row - col) / col;
            pascalList.add((int) result);
        }

        return pascalList;
    }
    public List<List<Integer>> pascalTriangleOptimal(int n) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            pascalTriangle.add(generateRow(i));
        }

        return pascalTriangle;
    }
    public static void main(String[] args) {
        PascalTriangleIII_6 pascalTriangleIII6 = new PascalTriangleIII_6();
        int n = 5;
        System.out.println("Pascal Triangle Brute: ");
        List<List<Integer>> pascalTriangleBrute = pascalTriangleIII6.pascalTriangleBrute(n);
        HelperMethods.printListOfLists(pascalTriangleBrute);
        System.out.println("Pascal Triangle Optimal: ");
        List<List<Integer>> pascalTriangleOptimal = pascalTriangleIII6.pascalTriangleOptimal(n);
        HelperMethods.printListOfLists(pascalTriangleOptimal);
    }
}
