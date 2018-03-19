package ReverseString42;

/**
 * @author duffywang
 * @date 2018年3月16日
 * @version 1.0
 *题目描述
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftReverse {
    private static String reverseSentence3(String str) {
        if(str.trim().equals(""))return str;
        String[] strings = str.split(" ");
        StringBuilder builder = new StringBuilder("");
        for(int i = strings.length-1;i >= 0 ;i--) {
        	if(i>0) {
        		builder.append(strings[i]+" ");
        	}else {
        		builder.append(strings[i]);
        	}
        }
        return builder.toString();
    }
    
	public void leftReverseSentence(String sentence,int n){
		if(sentence==null||n==0)return;
		if(n>sentence.length())return ;
		StringBuilder sb=new StringBuilder(sentence);
		for(int i=0;i<n;i++)
		{
			//直接添在后面
			sb.append(sb.charAt(0));
			//删除前面的
			sb.deleteCharAt(0);
		}
		System.out.println(sb);
	}
	
	/**三次反转
	 * @param sentence
	 * @param n
	 * @return
	 * abcdrfg 2->bacdefg->bagfedc->cdefgab
	 */
	public static String leftReverseSentence2(String sentence,int n) {
		if(sentence.length() < n)return sentence;
		char[] array = sentence.toCharArray() ;
		swap(array,0,n-1);
		swap(array,n,sentence.length()-1);
		swap(array,0,sentence.length()-1);
		StringBuilder sb = new StringBuilder("");
		for(char c:array) {
			sb.append(c);
		}
		return sb.toString();
		
	}
	private static void swap(char[] arr, int start, int end) {
		
		while(start < end) {
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
        }
	}
	public static void main(String[] args) {
		String reverseSentence3 = LeftReverse.reverseSentence3("I a big bad ass.");
		System.out.println(reverseSentence3);
		String string = LeftReverse.leftReverseSentence2("abcdefg", 3);
		System.out.println(string);
	
	}
}
