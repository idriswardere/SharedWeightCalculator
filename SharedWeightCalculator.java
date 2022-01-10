import java.util.*;

public class SharedWeightCalculator {
   
   public static void main(String[] args) {
      
      Scanner input = new Scanner(System.in);
      
      double[] weights = {45, 45, 35, 25, 15, 10, 5, 2.5, 1.25};
      Inventory home = new Inventory(weights);
      

      //ArrayList<ArrayList<Double>> pA = x.findPermutations(targetA);
      //ArrayList<ArrayList<Double>> pB = x.findPermutations(targetB);
      
      double targetA = 125;
      double targetB = 175;
      
      /**System.out.println(targetA+" permutations:");
      displayPermutations(home, targetA);
      System.out.println(targetB+" permutations:");
      displayPermutations(home, targetB);
      **/
      
      ArrayList<ArrayList<Double>> bestPair = home.findBestPair(targetA, targetB);
      System.out.println(bestPair.get(0));
      System.out.println(bestPair.get(1));
      
   }
   
   public static void displayPermutations(Inventory x, double target) {
      ArrayList<ArrayList<Double>> p = x.findPermutations(target);
      for (int i = 0; i < p.size(); i++) {
         for (int j = 0; j < p.get(i).size(); j++) {
            System.out.print(p.get(i).get(j) + " ");
         }
         System.out.println();
      }
   }
   
}