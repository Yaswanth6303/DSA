package easy;

public class LemonadeChange_2 {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;

        int five = 0;
        int ten = 0;
        int twenty = 0;

        for (int i = 0; i < n; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five > 0) {
                    ten++;
                    five--;
                } else {
                    return false;
                }
            } else {
                if (five > 0 && ten > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        LemonadeChange_2 lc = new LemonadeChange_2();
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println(lc.lemonadeChange(bills));
    }
}
