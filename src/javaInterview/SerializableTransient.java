package javaInterview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SerializableTransient {
	private String username;
	private transient String password;
	private Date logginDate=new Date();
	public SerializableTransient(String usernaem,String password ){
		this.username=username;
		this.password=password;
	}
	public String toString(){
		String pwd=null;
		if(password==null)
			pwd="NOT SET";
		else
			pwd=password;
		return "login info:\n"+"user:"+username+"\n logging date:"+logginDate.toString()+"\n password: "+pwd;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializableTransient loginInfo=new SerializableTransient("duffywang","xxxxxx");
		System.out.println(loginInfo.toString());
		
		try {
			ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("loginInfo.out"));
			o.writeObject(loginInfo);
			o.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ObjectInputStream in=new ObjectInputStream(new FileInputStream("loginInfo.out"));
			SerializableTransient loginInfo2=(SerializableTransient) in.readObject();
			System.out.println(loginInfo2.toString());
			//in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
