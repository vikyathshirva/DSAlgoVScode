package DynamicProgramming.Subsequences;

import java.util.HashMap;

import TestLibrary.*;

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

    public static void run() {
        SimpleTestLibrary testLibrary = new SimpleTestLibrary();
        testLibrary.test("1", () -> {
            assertDecodings(testLibrary, "10", 1);
        });
        testLibrary.test("2", () -> {
            assertDecodings(testLibrary, "06", 0);
        });
        testLibrary.test("3", () -> {
            assertDecodings(testLibrary, "226", 3);
        });
        testLibrary.test("4", () -> {
            assertDecodings(testLibrary, "0", 0);
        });
        testLibrary.test("5", () -> {
            assertDecodings(testLibrary, "123", 3);
        });
        // Execute all defined test cases
        testLibrary.runTests();
    }

    private static void assertDecodings(SimpleTestLibrary testLibrary, String input, int expected) {
        numWaysToDecode sol = new numWaysToDecode();
        int result = sol.numDecodings(input);
        SimpleTestLibrary.assertEquals(expected, result);
    }
}
