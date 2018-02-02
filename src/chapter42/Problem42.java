package chapter42;
/*输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
为简单起见，标点符号和普通字母一样处理。例如输入字符串“ I am a student.”，
则输出“ student. a am I” 

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
请定义一个函数实现字符串左旋转操作的功能。比如输入字符串“ abcdefg”和
数字 2.该函数左旋转 2 位得到的结果“ cdefgab".*/
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
