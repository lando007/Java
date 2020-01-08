
import java.text.DecimalFormat;

import java.util.Arrays;

/**
 * Created by luke.landon on 9/26/2017.
 */
public class Generics_Test {
    public static void main(String[] args){
        //utilize generic class to store stocks.
        Pair<String, Double > oStock = new Pair<>("orcl", 23.34);
        Triple<String, Integer, Integer> oFootBallFalcons = new Triple<>("Falcons" , 2, 1);
        Triple<String, Integer, Integer> oFootBallPanthers = new Triple<>("Panthers" , 2, 1);
        Triple<String, Integer, Integer> oFootBallBuccaneers = new Triple<>("Buccaneers" , 1, 1);
        Triple<String, Integer, Integer> oFootBallSaints = new Triple<>("Saints" , 1, 2);
        Triple<String, Integer, Integer> oFootBallPackers = new Triple<>("Packers" , 1, 2);
        Triple<String, Integer,Integer>[] aoTriple;
        aoTriple = new Triple[5];
       aoTriple[0] = oFootBallFalcons;
       aoTriple[1] = oFootBallPanthers;
       aoTriple[2] = oFootBallBuccaneers;
       aoTriple[3] = oFootBallSaints;
       aoTriple[4] = oFootBallPackers;

        Pair<String, Double>[] aoPair;
        aoPair = new Pair[5];
        for(int x = 0; x < aoPair.length; x++){
            String name = aoTriple[x].getFirst();
             int a = aoTriple[x].getSecond();
             int b = aoTriple[x].getThird();
            double aa = (double) a;
            double bb = (double) b;
            double ab = aa+bb;
            double dd = aa / ab;
             int winningRatio = aoTriple[x].getSecond() /aoTriple[x].getThird();
            double d = (double) winningRatio;
            Pair<String, Double > pair = new Pair<>(name, dd);
            aoPair[x] = pair;




        }
        DecimalFormat df = new DecimalFormat("#.00");
        double[] array = new double[5];
        for(int x = 0; x < aoPair.length; x++){

            System.out.println(aoPair[x].getFirst() + " Winning ratio is: ");
            String angleFormated = df.format(aoPair[x].getSecond());
            System.out.println(angleFormated);
            array[x] = aoPair[x].getSecond();
        }
        Arrays.sort(array);
        String angleFormated = df.format(array[4]);
        System.out.println("The Team that is winning has a winning ratio of: "+angleFormated);










    }
}