package chapter33;
/*�������ų���С����
 *����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 *������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 *1.���ǵ�����ִ��������ַ���ȥ�ȽϺͱ���
 *2.ab<ba a<b
 *  ba<ab b<a
 *  ab=ba a=b
 *  ����ıȽϹ���a��bΪ�ַ��� */
import java.util.Arrays;
import java.util.Comparator;

public class Problem33 {
	public void printMin(int []array){
		int n=array.length;
		String[] str=new String[n];
		String s="";
		StringBuilder sb=new StringBuilder();
		
		//�����������ַ�������
		for(int i=0;i<n;i++)
		{	//����ת��Ϊ�ַ���
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
