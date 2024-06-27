package DynamicProgramming.SubsequencesOrSubstrings;

public class countPalindromicSubstrings {

    /**
     * 
     * the brute force way to count all palindromic substrings would have been
     * to geenrate all substrings causing us O(n^2) and check for each in O(n) time
     * if its a palindrome this would be O(n^3)
     * using dp tabel we trade space for time and we can acheive O(N^2) time ans B(N^2) grid space.  * 
     * 
     * The final dp table looks like this:
     * 
     * T F F F T
     * F T F T F
     * F F T F F
     * F F F T F
     * F F F F T
     * The palindromic substrings are: a, b, c, b, a, bcb, abcba.
     * 
     */
    public int countSubstrings(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int i = n; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) {
                        count++;
                    }
                }

            }
        }

        return count;

    }
}
