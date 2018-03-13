package LessKNumber;

import java.util.ArrayList;
import java.util.Arrays;

public class Partition {
	
    /**基于partition的算法平均时间复杂度为O(n),比堆的要快，但会修改数组结构
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(Integer [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null || k <= 0 )
            return res;
        if(k == input.length) {
			ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(input));
			return list;
		}
        else {
        int end = input.length-1;
        int start = 0;
        int index = partition(input,start,end);
        while(index != k-1){
            if(index > k-1)
            {
                end = index - 1;
                index = partition(input,start,end);
            }
            else{
                start = index + 1;
                index = partition(input,start,end);
            }
        }
        for(int i = 0;i < k;i++){
            res.add(input[i]);
        }
        
        return res;
        }
    }
    private int  partition(Integer[] input ,int start,int end){
        int i = start;
        int j = end ;
        int pivot = input[i];
        
        while(i < j) {
        	while(i < j && pivot > input[i])
        		i++;
        	input[j] = input[i];
        	while(i < j && pivot <= input[j])
        		j--;
        	input[i] = input[j];
        }
        input[i] = pivot;
        return i;
        
//        while(i < j){
//            while(i < j && pivot <= input[j])
//            	j--;
//            input[i] = input[j];
//            while(i < j && pivot > input[i])
//            	i++;
//            input[j] = input[i];
//        }
//        input[i] = pivot;
//        return i;
        
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	Partition partition = new Partition();
    	Integer[] input = {5,6,9,1,3,2,7};
    	ArrayList<Integer> list = partition.GetLeastNumbers_Solution(input,7);
    	for(Integer val:list) {
    		System.out.println(val);
    	}
	}

}
