package Stacks;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int[][] comb = new int[position.length][2];
        for(int i=0;i<position.length;i++) {
            comb[i][0] = position[i];
            comb[i][1] = speed[i];
        }
        Arrays.sort(comb, Comparator.comparingInt((o) -> o[0]));
        for(int i=position.length-1;i>=0;i--) {
            double curTime = (target - position[i])/ speed[i];

            if(!stack.isEmpty() && curTime < stack.peek()) {
                continue;
            } else {
                stack.push(curTime);
            }
        }
        return stack.size();

    }

    
    
}
