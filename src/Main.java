import javax.print.DocFlavor;

/**
 * Created by dave on 2015/9/10.
 */
public class Main {
    public static void main(String[] args){
        //Main.gameOfLife();
//        Main.medianOfTwoArray();
//        Main.regularmatch();
//        Main.containerWithMostWater();
//        Main.divideTwoInteger();
//        Main.substringconcatation();
//        Main.multistring();
//        Main.wildCard();
        Main.permutation();
    }
    private static void permutation(){
        PermutationsII permutationsII = new PermutationsII();
        permutationsII.test();
    }
    private static void wildCard(){
        WildCard card = new WildCard();
        card.test();
    }
    private static void multistring(){
        MultiString string = new MultiString();
        string.test();
    }
    private static void substringconcatation(){
        SubStringWithConcatation sub = new SubStringWithConcatation();
        sub.test();
    }
    public static void containerWithMostWater(){
        ContainerWithMostWater water = new ContainerWithMostWater();
        water.test();
    }
    public static void gameOfLife(){
        GameOfLife life = new GameOfLife();
        life.test();
    }
    public static void medianOfTwoArray(){
        MedianOfTwoSortedArray array = new MedianOfTwoSortedArray();
        array.test();
    }
    public static void regularmatch(){
        RegularExpressionMatching match = new RegularExpressionMatching();
        match.test();
    }
    public static void divideTwoInteger(){
        DivideTwoIntegers integers = new DivideTwoIntegers();
        integers.test();
    }

}
