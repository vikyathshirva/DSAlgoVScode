import Backtracking.*;

public class MainApp {


    public static void main(String[] args) {



//        List<Integer> test = new ArrayList<>();
//        test.add(7);
//        test.add(3);
//        test.add(5);
//
//        Permuations permuations = new Permuations();
//        System.out.println(permuations.permute(test));


//        List<Integer> set = Arrays.asList(1,2,3,4);
//        PowerSet powerSet = new PowerSet();
//        Subsets subsets = new Subsets();

//        System.out.println(subsets.combination(4,5));

//        System.out.println(powerSet.allPowerSet(power));

//        System.out.println(powerSet.generatePowerSet(power));


//        BalancedParen balancedParen = new BalancedParen();
//        System.out.println(balancedParen.generateBalParen(2));


//        PalindromicDecomposition palindromicDecomposition = new PalindromicDecomposition();
//        System.out.println(palindromicDecomposition.findPalinDecom("611116"));


        int [] nums=  {2,3,6,7};


        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.generateComSum(nums,7));




    }
}
