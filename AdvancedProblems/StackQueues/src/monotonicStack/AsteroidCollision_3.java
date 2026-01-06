package monotonicStack;

import java.util.ArrayList;
import java.util.List;

public class AsteroidCollision_3 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (asteroids[i] > 0) {
                stack.add(asteroids[i]);
            } else {
                while (!stack.isEmpty() && Math.abs(asteroids[i]) > stack.getLast() && stack.getLast() > 0) {
                    stack.removeLast();
                }

                if (!stack.isEmpty() && Math.abs(asteroids[i]) == Math.abs(stack.getLast())) {
                    stack.removeLast();
                } else if (stack.isEmpty() ||stack.getLast() < 0) {
                    stack.add(asteroids[i]);
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }
        return result;
    }
    static void main() {
        AsteroidCollision_3 solution = new AsteroidCollision_3();
        int[] asteroids = {4, 7, 1, 1, 2, -3, -7, 17, 15, -18, -19};
        int[] result = solution.asteroidCollision(asteroids);
        System.out.print("The state of asteroids after collisions is: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
