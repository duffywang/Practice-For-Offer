package javaInterview;

import java.util.Scanner;

public class InputLine {
	public static void main(String[] args) {
		//ReadData r=new ReadData();
		Scanner input=new Scanner(System.in);
		//Scanner input=new Scanner("abc 123 bb ss");
		String s=input.nextLine();
		String[] arr=s.split(" ");
		
		System.out.println(arr.length+"\t"+arr);
	}


}
