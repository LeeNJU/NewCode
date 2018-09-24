package Stack;

import java.util.Stack;

//题目描述:给定一个行星数组，包含正负数字，正数向右移动，负数向左移动，正数负数碰撞，绝对值大的保留下来，绝对值小的删除，如果一样大，同时删除，求最后剩下的元素，例如asteroids = [5, 10, -5]，10和-5
//        碰撞，-5删除，剩下[5,10]
//解法描述:利用栈，剩下的元素一定是不能发生碰撞的，所以负数一定在左边，正数一定在右边，遍历数组

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < asteroids.length; ++i) {
            // 正数一定放入栈中，如果栈顶元素为负，当前元素也为负，方向一致
            if (asteroids[i] > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.add(asteroids[i]);
            } else if (stack.peek() == -asteroids[i]) {
                stack.pop();
            } else if (stack.peek() < -asteroids[i]) {
                stack.pop();
                --i;
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; --i) {
            result[i] = stack.pop();
        }

        return result;
    }
}
