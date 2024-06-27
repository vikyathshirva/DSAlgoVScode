package DynamicProgramming.Strings;

public class printLongestCommonSubsequence {


    public int findLCSBU(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        for(int i=0;i<=a.length();i++) {
            dp[i][0] = 0;
        }
        for(int j=0;j<=b.length();j++) {
            dp[0][j] = 0;
        }

        for(int i=0;i<=a.length();i++) {
            for(int j=0;j<=b.length();j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
                }
            }
        }

        //code to store ans in char array of the longest common subsequence.
        int len = dp[a.length()][b.length()];
        int idx = len-1;
        int m = a.length();
        int n = b.length();
        char[] ans = new char[len];

        while(m > 0 && n > 0) {
            if(a.charAt(m) == b.charAt(n)) {
                ans[idx] = a.charAt(m);
                m--;
                n--;
                idx--;
            } else if (dp[m-1][n] > dp[m][n-1]){
                 m--;
            } else {
                n--;
            }
        }

        return dp[a.length()][b.length()];
    }
    
}
