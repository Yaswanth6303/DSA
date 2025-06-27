public class SumOfDigits_9 {
    public int addDigits(int number) {
        if (number < 10) {
            return number;
        }
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return addDigits(sum);
    }
    public static void main(String[] args) {
        SumOfDigits_9 solution = new SumOfDigits_9();
        int num = 529;
        int result = solution.addDigits(num);
        System.out.println("Sum of digits: " + result);
    }
}
