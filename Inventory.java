import java.util.*;

public class Inventory {
   
   private ArrayList<Double> weights; 
   private int count;
   private double bar;
   private static ArrayList permutations = new ArrayList<ArrayList<Double>>();
   
   public Inventory() {
      weights = new ArrayList<Double>();
      count = 0;
      bar = 45;
   }
   
   public Inventory(ArrayList<Double> weights) {
      this.weights = weights;
      count = weights.size();
      bar = 45;
   }
   
   public Inventory (double[] weights) {
      this.weights = new ArrayList<Double>();
      for (int i = 0; i < weights.length; i++) {   
         this.weights.add(weights[i]);
      }
      count = this.weights.size();
      bar = 45;
   }
   
   public Inventory(ArrayList<Double> weights, double bar) {
      this.weights = weights;
      count = weights.size();
      this.bar = bar;
   }
   
   public Inventory (double[] weights, double bar) {
      this.weights = new ArrayList<Double>();
      for (int i = 0; i < weights.length; i++) {   
         this.weights.add(weights[i]);
      }
      count = this.weights.size();
      this.bar = bar;
   }
   
   public void add(double x) {
      weights.add(x);
      count++;
   }
   
   public void add(double[] xArr) {
      for (int i = 0; i < xArr.length; i++) {
         weights.add(xArr[i]);
         count++;
      }
   }
   
   public void add(ArrayList<Double> xArr) {
      for (int i = 0; i < xArr.size(); i++) {
         weights.add(xArr.get(i));
         count++;
      }
   }
   
   public boolean remove(double x) {
      for (int i = 0; i < weights.size(); i++) {
         if (weights.get(i) == x) {
            count--;
            return true;
         }
      }
      return false;
   }
   
  public void clear() {
      weights = new ArrayList<Double>();
      count = 0;
   }
   
   public ArrayList<Double> getWeights() {
      return weights;
   }
   
   public int getCount() {
      return count;
   }
   
   public double getBar() {
      return bar;
   }
   
   public void setBar(double x) {
      bar = x;
   }
   
   public ArrayList<ArrayList<Double>> findBestPair(double targetA, double targetB) {
      
      ArrayList<ArrayList<Double>> pA = findPermutations(targetA);
      ArrayList<ArrayList<Double>> pB = findPermutations(targetB);
      
      int[] bsi = new int[2];
      double bestScore = 0;
      for (int i = 0; i < pA.size(); i++) {
         for (int j = 0; j < pB.size(); j++) {
            double score = scorePair(pA.get(i), pB.get(j));
            if (score > bestScore) {
               bestScore = score;
               bsi[0] = i;
               bsi[1] = j;
            }
         }
      }
      ArrayList ret = new ArrayList<ArrayList<Double>>();
      ret.add(pA.get(bsi[0]));
      ret.add(pB.get(bsi[1]));
      return ret;
   }
   
   public ArrayList<ArrayList<Double>> findPermutations(double target) {
      double increment = 2.5;
      double newTarget = ((target-bar)/2)-(target%increment);
      ArrayList<ArrayList<Double>> all = sum_up(weights, newTarget);
      ArrayList<ArrayList<Double>> ret = new ArrayList<ArrayList<Double>>();
      for (int i = 0; i < all.size(); i++) {
         if (!ret.contains(all.get(i))) {
            ret.add(all.get(i));
         }
      }
      return ret;
   }
   
   public static double scorePair(ArrayList<Double> a, ArrayList<Double> b) {
      int common = 0;
      ArrayList<Double> aNew = (ArrayList<Double>)a.clone();
      ArrayList<Double> bNew = (ArrayList<Double>)b.clone();
      for (int i = 0; i < aNew.size(); i++) {
         for (int j = 0; j < bNew.size(); j++) {
            if (aNew.get(i).equals(bNew.get(j)) && aNew.get(i) != -1) {
               common++;
               aNew.set(i, -1.0);
               bNew.set(j, -1.0);
               break;
            }
         }
      }
      return (double)(common) - ((aNew.size() + bNew.size())/1000.0);
   }

   private static void sum_up_recursive(ArrayList<Double> numbers, double target, ArrayList<Double> partial) {
       double s = 0;
       for (double x: partial) s += x;
       if (s == target)
            permutations.add(partial);
       if (s >= target)
            return;
       for(int i=0;i<numbers.size();i++) {
             ArrayList<Double> remaining = new ArrayList<Double>();
             double n = numbers.get(i);
             for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
             ArrayList<Double> partial_rec = new ArrayList<Double>(partial);
             partial_rec.add(n);
             sum_up_recursive(remaining,target,partial_rec);
       }
    }
    
    private static ArrayList<ArrayList<Double>> sum_up(ArrayList<Double> numbers, double target) {
        permutations = new ArrayList<ArrayList<Double>>();
        sum_up_recursive(numbers,target,new ArrayList<Double>());
        return permutations;
    }
   
   
   public String toString() {
      
      String ret = "";
      for (int i = 0; i < count; i++) {
         ret += weights.get(i) + " ";
      }
      return ret;
      
   }
   
}