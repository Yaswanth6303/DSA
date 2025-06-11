package faqMedium;

public class PascalTriangleI_4 {
    public int pascalTriangle(int r, int c) {
        return nCr(r - 1, c - 1);
    }
    public static int nCr(int n, int r) {
        int result = 1;
        for(int i = 0; i < r; i++) {
            result = result * (n - i);
            result = result / (i + 1);
        }

        return result;
    }
    public static void main(String[] args) {
        PascalTriangleI_4 pascalTriangle1 = new PascalTriangleI_4();
        int r = 4;
        int c = 4;
        System.out.print("At row number " + r + " column number " + c + " value is: ");
        System.out.println(pascalTriangle1.pascalTriangle(r, c));
    }
}
