package javaInterview;

import java.io.UnsupportedEncodingException;

public class CutString {
	public String cutString(String orginal,int count) throws UnsupportedEncodingException{
		if(orginal!=null&&!"".equals(orginal))
			orginal=new String (orginal.getBytes(),"GBK");
		if(count>0&&count<orginal.getBytes("GBK").length)
		{
			StringBuffer buff=new StringBuffer();
			char c;
			for(int i=0;i<count-1;i++)
			{
				c=orginal.charAt(i);
				buff.append(c);
				if(isChinese(c))
					--count;
			}
			return buff.toString();
			
		}
		return orginal;
	}
	private boolean isChinese(char c) throws UnsupportedEncodingException {
		// ÅÐ¶Ï×Ö·ûÊÇ·ñÎªºº×Ö£¬"GBK"±àÂëÏÂºº×Ö×Ö½ÚÊýÎª2
		return String.valueOf(c).getBytes("GBK").length>1;
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		CutString test=new CutString();
		String str=test.cutString("aasdcde", 6);
		System.out.println(str);
	}

}
