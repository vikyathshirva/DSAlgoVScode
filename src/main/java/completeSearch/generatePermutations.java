package CompleteSearch;
import java.util.*;


public class generatePermutations {

    private List<Integer> result = new ArrayList<>();
    boolean[] chosen;
    int n;

    public List<List<Integer>> generateAllPerm(int n) {
        List<List<Integer>> result = new ArrayList<>();
        search();
        return result;
    }

    public void search() {
        if(result.size() == n) {    
            //process permutation
        } else {
            for(int i=0;i<n;i++){
                if(chosen[i]) {
                    continue;
                }
                chosen[i] = true;
                result.add(i);
                search();
                chosen[i] = false;
                result.remove(result.size()-1);
            }
        }
    }


    public List<List<Integer>> generatePerms(List<Integer> input) {
        List<List<Integer>> result = new ArrayList<>();
        generate(input, result, 0);
        return result;
    }

    public void generate(List<Integer> list, List<List<Integer>>result, int idx) {
        if(idx == list.size()-1) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx;i<list.size();i++) {
            Collections.swap(list, idx, i);
            generate(list, result, idx+1);
            Collections.swap(list, idx, i);
        }
    }
    
}
