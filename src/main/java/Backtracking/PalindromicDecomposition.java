package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromicDecomposition {

   public List<List<String>> findPalinDecom(String input){
       List<List<String>> result = new ArrayList<>();
       backtrack(input,0,new ArrayList<String>(),result);
       return result;
   }

    private void backtrack(String input, int offset, List<String> paln, List<List<String>> result) {
       if(offset == input.length()){
           result.add(new ArrayList<>(paln));
           return;
       }

       for(int i=offset+1;i<=input.length();i++){
           String palindrom = input.substring(offset,i);
           if(checkPalin(palindrom)){
               paln.add(palindrom);
               backtrack(input,i,paln,result);
               paln.remove(paln.size()-1);
           }
       }
    }

    private boolean checkPalin(String palindrom) {
        int i=0,j=palindrom.length()-1;
        while( i < j){
            if(palindrom.charAt(i) != palindrom.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
