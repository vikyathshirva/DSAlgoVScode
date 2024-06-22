package Stacks;

import java.util.*;

public class DailyTemperatures {

    public void pusher(Stack<Integer> mon, int index, int[] temps, int[] result) {
        while (!mon.isEmpty() && temps[mon.peek()] < temps[index]) {
            int prevIdx = mon.pop();
            result[prevIdx] = index - prevIdx;
        }
        mon.push(index);
    }

    public int[] increaseCalculator(int[] temps) {
        int[] result = new int[temps.length];
        Stack<Integer> monInc = new Stack<Integer>();
        for (int i = 0; i < temps.length; i++) {
            pusher(monInc, i, temps, result);
        }
        return result;

    }

}
