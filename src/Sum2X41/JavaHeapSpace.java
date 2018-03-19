package Sum2X41;

import java.util.ArrayList;
import java.util.Iterator;

public class JavaHeapSpace {
    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

         int small = 1;
         int big = 2;
         int middle = (sum+1)/2;
         int curSum = small+big;
         while(small<=middle){
             if(curSum == sum){
                 ArrayList<Integer> list = new ArrayList<Integer>();
                 for(int i = small;i<=big;i++){
                     list.add(i);
                 }
                 res.add(list);
             }
             while(curSum > sum&&small<middle){
                 curSum -= small;
                 small++;
                 //因为可能达到sum，需要添加，否则执行big++，将增大结果，将一直得不到结果
             }

               big++;
               curSum+=big;

         }
         return res;

         
     }
    public static void main(String[] args) {
		Test test = new Test();
		ArrayList<ArrayList<Integer>> list = JavaHeapSpace.FindContinuousSequence(15);
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
