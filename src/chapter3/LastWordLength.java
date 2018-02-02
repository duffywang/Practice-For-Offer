package chapter3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LastWordLength {
	
	    public static int lastWordLength(String string){
	    	List list = new ArrayList();
	    	List list2 = new LinkedList();
	    	string = string.trim();
	        String str[] = string.split(" ");
	        return str[str.length-1].length();
	        
	       // String lastWord = string.substring(string.lastIndexOf(" "));
	        //return lastWord.length();
	    }
	    
	    public static void main(String[] args){
	        Scanner scanner = new Scanner(System.in);
	        //while(scanner.hasNext()) {
	            System.out.println(lastWordLength(scanner.nextLine()));
	        //}
	    }
	}


