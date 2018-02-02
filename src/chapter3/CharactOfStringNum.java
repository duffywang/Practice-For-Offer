package chapter3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharactOfStringNum {
	public static int nums(String string,String c) {
		if(string == null) {
			return 0;
		}
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		char[] charArray = string.toCharArray();
		for(char item:charArray) {
			if(map.containsKey(item)) {
				map.put(item, map.get(item)+1);
			}
			map.put(item, 0);
		}
		return map.get(c);
	}
	public static void main(String[] args) {
		String all = "";
		String one = "";
		char [] array;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			all = scanner.nextLine();
			one = scanner.nextLine();
			array = all.toCharArray();
			for(char item:array) {
				if(map.containsKey(item)) {
					map.put(item, map.get(item)+1);
				}
				map.put(item, 0);
			}
			
		}
		System.out.println(map.get(one));
	}

}
