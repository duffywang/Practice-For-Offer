package chapter42;
/*����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣
Ϊ������������ź���ͨ��ĸһ���������������ַ����� I am a student.����
������� student. a am I�� 

�ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β����
�붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ����������ַ����� abcdefg����
���� 2.�ú�������ת 2 λ�õ��Ľ���� cdefgab".*/
public class Problem42 {
	public void reverseSentence(String sentence){
		String[] array=sentence.split(" ");
		int n=array.length;
		for(int i=n-1;i>=0;i--)
		{
			System.out.print(array[i]+" ");
		}
	}
	public void leftReverseSentence(String sentence,int n){
		if(sentence==null||n==0)return;
		if(n>sentence.length())return ;
		StringBuilder sb=new StringBuilder(sentence);
		for(int i=0;i<n;i++)
		{
			sb.append(sb.charAt(0));
			sb.deleteCharAt(0);
		}
		System.out.println(sb);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem42 test=new Problem42();
		test.reverseSentence("I am a student.");
		System.out.println(
				);
		test.leftReverseSentence("abcdefg", 2);
	}

}
