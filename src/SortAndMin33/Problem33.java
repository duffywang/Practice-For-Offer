package SortAndMin33;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Problem33 {
	public String printMin(int []numbers){
        ArrayList<Integer> list = new ArrayList<>();
        for(int number:numbers){
            list.add(number);
        }
        Collections.sort(list,new Comparator<Integer>(){
            public int compare(Integer i1,Integer i2){
                String s1 = i1 + "" +i2;
                String s2 = i2 + "" +i1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder str = new StringBuilder("");
        for(int s:list){
            str.append(s);
        }
        return str.toString();

    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem33 test=new Problem33();
		int [] array={321,32,3,94};
		System.out.println(test.printMin(array));
		
	}

}
