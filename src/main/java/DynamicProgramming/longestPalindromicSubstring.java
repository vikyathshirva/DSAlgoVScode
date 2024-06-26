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
    



} 
    