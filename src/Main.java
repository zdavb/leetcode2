/**
 * Created by dave on 2015/9/10.
 */
public class Main {
    public static void main(String[] args){
        //Main.gameOfLife();
//        Main.medianOfTwoArray();
//        Main.regularmatch();
        Main.containerWithMostWater();
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

}
