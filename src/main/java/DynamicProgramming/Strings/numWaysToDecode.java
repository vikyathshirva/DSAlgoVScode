package DynamicProgramming.Strings;

import java.util.HashMap;

public class numWaysToDecode {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return numDecodingsHelper(s, s.length() - 1, new HashMap<>());
    }

    private int numDecodingsHelper(String s, int index, HashMap<Integer, Integer> memo) {
        // Base case: if we've processed all characters
        if (index < 0) {
            return 1;
        }

        // Check if we already have a result for this subproblem
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        int count = 0;

        // Take one digit if it's not '0'
        if (s.charAt(index) != '0') {
            count = numDecodingsHelper(s, index - 1, memo);
        }

        // Take two digits if they form a valid number (10-26)
        if (index > 0 && s.charAt(index - 1) != '0') {
            int twoDigit = Integer.parseInt(s.substring(index - 1, index + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                count += numDecodingsHelper(s, index - 2, memo);
            }
        }

        // Store the result in the memoization map
        memo.put(index, count);

        return count;
    }

    public static void main(String[] args) {
        numWaysToDecode sol = new numWaysToDecode();
        System.out.println(sol.numDecodings("10")); // Expected output: 1
        System.out.println(sol.numDecodings("06")); // Expected output: 0
        System.out.println(sol.numDecodings("226")); // Expected output: 3
        System.out.println(sol.numDecodings("0")); // Expected output: 0
        System.out.println(sol.numDecodings("123")); // Expected output: 3
    }
}
