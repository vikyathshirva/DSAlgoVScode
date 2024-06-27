package DynamicProgramming.SubsequencesOrSubstrings;

public class longestPalindromicSubsequence {

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String longestCommonSubsequnce(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        int m = a.length();
        int n = b.length();

        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int j = 0; j <= m; j++) {
            dp[j][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = m;
        int j = n;
        char[] s = new char[dp[m][n]];
        int idx = dp[m][n] - 1;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                s[idx] = a.charAt(i - 1);
                i--;
                j--;
                idx--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return new String(s);
    }

    public String longestPalindrome(String s) {
        String nS = reverseString(s);
        return longestCommonSubsequnce(s, nS);
    }

}
