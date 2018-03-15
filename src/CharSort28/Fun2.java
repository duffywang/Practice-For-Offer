package CharSort28;

import java.util.ArrayList;
import java.util.Collections;

public class Fun2 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null||str.length() == 0)return res;
        char[] arr = str.toCharArray();
 
        helper(arr,res,0);
        Collections.sort(res);
        return res;
       
    }
    private void helper(char[] arr,ArrayList<String> res,int n){
        if(n == arr.length-1){
            String val = String.valueOf(arr);
            if(!res.contains(val)) 
                res.add(val);
            	//system.out.print(val);
        }else{
            for(int j=n;j<arr.length;j++){
                swap(arr,n,j);
                helper(arr,res,n+1);
                swap(arr,n,j);
            }

        }

    }
    private void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
}
