public class PrimeNumber_6 {
    /**
     * Time Complexity: O(sqrt(n))
     * Space Complexity: O(sqrt(n))
     */
    public boolean checkPrime(int number) {
        if (number <= 1) {
            return false;
        }
        return isPrime(number, 2);
    }
    public boolean isPrime(int number, int i) {
        if (i > Math.sqrt(number)) return true;
        if (number % i == 0) return false;
        return isPrime(number, i + 1);
    }
    public static void main(String[] args) {
        PrimeNumber_6 solution = new PrimeNumber_6();
        int number = 4;
        boolean result = solution.checkPrime(number);
        System.out.print("The given number " + number + " is a ");
        if (result) {
            System.out.println("Prime number");
        } else {
            System.out.println("not a Prime number");
        }
    }
}
