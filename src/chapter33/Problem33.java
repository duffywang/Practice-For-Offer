package chapter33;
/*把数组排成最小的数
 *输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *1.考虑到会出现大数，用字符串去比较和保存
 *2.ab<ba a<b
 *  ba<ab b<a
 *  ab=ba a=b
 *  特殊的比较规则，a、b为字符串 */
import java.util.Arrays;
import java.util.Comparator;

public class Problem33 {
	public void printMin(int []array){
		int n=array.length;
		String[] str=new String[n];
		String s="";
		StringBuilder sb=new StringBuilder();
		
		//整型数组变成字符串数组
		for(int i=0;i<n;i++)
		{	//整型转变为字符串
			str[i]=String.valueOf(array[i]);
		}
		Arrays.sort(str,new Comparator<String>(){
			public int compare(String a,String b)
			{
				String c1=a+b;
				String c2=b+a;
				return c1.compareTo(c2);
			}
		});
		for(int i=0;i<n;i++)
		{
			//sb.append(str[i]);
			s=s+str[i];
		}
		System.out.println(s.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem33 test=new Problem33();
		int [] array={321,32,3,94};
		test.printMin(array);
	}

}
