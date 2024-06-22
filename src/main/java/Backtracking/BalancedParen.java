package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class BalancedParen {

    public List<String> generateBalParen(int numPairs){
        List<String> result = new ArrayList<>();
        backtrack(numPairs,numPairs,"",result);
        return result;
    }

    private void backtrack(int leftPair, int rightPair, String curr, List<String> result) {
        if( leftPair == 0 && rightPair == 0){
            result.add(curr);
        }

        if(leftPair > 0){
            backtrack(leftPair-1,rightPair,curr+"(",result);
        }

        if(leftPair < rightPair){
            backtrack(leftPair,rightPair-1,curr+")",result);
        }
    }


}
