package Sum2X41;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    Integer small = 1;
    Integer big = 2;
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

         Integer middle = (sum+1)/2;
         Integer curSum = small+big;
         while(small<middle){
        	 add2List(curSum,sum);
             while(curSum > sum&&small<middle){
                 curSum -= small;
                 small++;
                 add2List(curSum,sum);
             }
             big++;
             curSum += big;
         }
         return res;
     }
    
    private void add2List(int curSum,int sum) {
        if(curSum == sum){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = small;i<=big;i++){
                list.add(i);
            }
            res.add(list);
            list = null;
            
        }
    	
    }
    public static void main(String[] args) {
		Test test = new Test();
		ArrayList<ArrayList<Integer>> list = test.FindContinuousSequence(15);
		Iterator<ArrayList<Integer>> iterator = list.iterator();
		while(iterator.hasNext()) {
			ArrayList<Integer> next = iterator.next();
			Iterator<Integer> iterator2 = next.iterator();
			while(iterator2.hasNext()) {
				Integer i = iterator2.next();
				System.out.print(i+" ");
			}
			System.out.println();
		}

	}

}
