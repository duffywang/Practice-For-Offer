package chapter4;
/*�滻�ո�
 *��ʵ��һ�����������ַ����е�ÿ���ո��滻�ɡ� %20�� 
 *˼·1����StringBuilder
 *2.String.replaceAll(" ","%20") */
public class ReplaceBlank {
	public static String ReplaceBlank(String s){
		if(s==null) return null;
		StringBuilder input=new StringBuilder();
		
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==' '){
				input.append("%");
				input.append("2");
				input.append("0");
			}
			else
			{
				input.append(String.valueOf(s.charAt(i)));
			}
		}
		return new String(input);
	}
	public String ReplaceBlank2(String string)
	{
		return string.replaceAll(" ","%20");
	}
	public static void main(String []args) {
		// TODO Auto-generated method stub
		String output=ReplaceBlank("duffy is great");
		System.out.println(output);
		ReplaceBlank test=new ReplaceBlank();
		System.out.println(test.ReplaceBlank2("We Are Happy"));
		

	}
}
