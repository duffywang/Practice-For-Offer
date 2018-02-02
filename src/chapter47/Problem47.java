package chapter47;
/*不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、 -、 *、 /四则
运算符号
思路：不能用四则运算考虑用位计算来
1.不考虑进位的,0+0,1+0,0+1用异或计算能直接呈现出来
2.当有进位的，数字会消失如1+1，用与计算记录再向左移动一位
3.直到不产生进位为止*/
public class Problem47 {
	public int add(int num1,int num2){
		int sum=0;
		int carry=0;
		while(num2!=0)
		{
			sum=num1^num2;
			carry=(num1&num2)<<1;
			num1=sum;
			num2=carry;
		}
		return num1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem47 test=new Problem47();
		int res=test.add(16, 7);
		System.out.println(res);
	}

}
