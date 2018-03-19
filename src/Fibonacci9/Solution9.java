package Fibonacci9;



/**
 * @author duffywang
 * @date 2018年3月18日
 * @version 1.0
 *大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 *用递归很慢1700ms
 *而迭代只用11ms
 */
public class Solution9 {
	
	public long fibonacci(int n){
		if(n==0) return 0;
		if(n==1) return 1;
		
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
    public int Fibonacci2(int n) {
        if(n == 1)return 1;
        if(n == 0)return 0;
        int a = 0,b =1;
        int temp ;
        for(int i=0;i<n;i++){
            temp = b;
            b+=a;
            a = temp;
        }
        return a;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution9 test=new Solution9();
		long res=test.fibonacci(6);
		System.err.println(res);
	}

}
