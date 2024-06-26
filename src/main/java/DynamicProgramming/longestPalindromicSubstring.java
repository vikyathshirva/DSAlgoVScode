package DynamicProgramming;
import java.util.*;

public class longestPalindromicSubstring {

    //O(n2)
    public String longestPalind(String s) {
        int n = s.length();
        String res = "";
        int maxLen = 0;
        for(int i=0;i<n;i++) {
            //odd length
            int left = i;
            int right = i;
            while(left >=0 && right <=n && s.charAt(left) == s.charAt(right)) {
               if(left - right +1 > maxLen) {
                res = s.substring(left, right+1);
                maxLen = right - left +1;
               } 
               left -= 1;
               right += 1;
            }


            //even length
            left = i;
            right = i;
            while(left >=0 && right <=n && s.charAt(left) == s.charAt(right)) {
               if(left - right +1 > maxLen) {
                res = s.substring(left, right+1);
                maxLen = right - left +1;
               } 
               left -= 1;
               right += 1;
            }
        }

        return res;
    }

    //dynamic programming (On2)
    public String longestPalinDP(String s) {
        int longest = 0;
        int left = 0;
        int right=1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=s.length();i>=0;i--) {
            for(int j=i;j<s.length();j++) {
                if(i == j) {
                    dp[i][j] = true;
                } else if(s.charAt(i) == s.charAt(j)) {
                    if(j-i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j-i+1 > longest) {
                    longest = j-i+1;
                    left = i;
                    right = j+1;
                }

            }
        }
        return s.substring(left, right+1);
    }




} 
    
