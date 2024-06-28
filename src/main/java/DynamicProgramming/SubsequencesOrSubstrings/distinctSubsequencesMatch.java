package DynamicProgramming.SubsequencesOrSubstrings;

import java.util.Arrays;

public class distinctSubsequencesMatch {

    public int subsequenceMatch(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return recusive(s, t, 0, 0, dp);
    }

    public int recusive(String s, String t, int idxS, int idxT, int[][] dp) {
        if (dp[idxS][idxT] != -1) {
            return dp[idxS][idxT];
        }

        if (idxS >= s.length()) {
            return 1;
        }

        if (idxT >= t.length()) {
            return 0;
        }

        if (s.charAt(idxS) == s.charAt(idxT)) {
            dp[idxS][idxT] = recusive(s, t, idxS + 1, idxT + 1, dp) + recusive(s, t, idxS + 1, idxT, dp);
            return dp[idxS][idxT];
        }

        dp[idxS][idxT] = recusive(s, t, idxS + 1, idxT, dp);
        return dp[idxS][idxT];
    }

}
