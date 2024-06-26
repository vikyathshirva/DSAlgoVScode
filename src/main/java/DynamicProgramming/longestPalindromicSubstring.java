package DynamicProgramming;

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
    /**
     * Center Expansion Approach:
     * - In the worst case, expand around each character and between each pair of
     * characters in the string.
     * - For each center (character or between characters), expand outwards until
     * you no longer have a palindrome.
     * - This results in roughly O(n) centers (considering both single characters
     * and pairs of characters),
     * and each center expansion could take O(n) time in the worst case.
     * 
     * Overall Complexity:
     * - Given that you have O(n) centers and each center might expand up to O(n)
     * times in the worst case,
     * the overall time complexity is O(n^2).
     * 
     * Comparative Analysis:
     * - The dynamic programming (DP) approach optimizes this by precomputing
     * whether substrings are palindromic
     * in O(n^2) time using a DP table, and then using this table to efficiently
     * find the longest palindromic
     * substring in O(n^2) time.
     * - Thus, the DP approach is generally more efficient than the center expansion
     * method, especially for
     * longer strings where O(n^2) is more manageable than O(n^3).
     */
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
    
