package javaInterview;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author duffywang
 *1. 总决赛的参赛队伍为n支，n为偶数； 
2. 进入前1/2的队伍才有资格进入淘汰赛； 
3. 队伍按积分排名，具体规则为：胜一场积3分；平一场积1分；负一场积0分。
队伍首先按积分降序排列，积分相同按净胜球数降序排列，仍然相同的按进球数降序排列。
样例输入：
4 
A 
B 
C 
D 
A-B 1:1 
A-C 2:2 
A-D 1:0 
B-C 1:0 
B-D 0:3 
C-D 0:3 
2 
a 
A 
a-A 2:1
 */
public class SoccerGame {

	public static void main(String[] args) {
		System.out.println("开始输入：");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			//第一行一共有N只球队参加比赛
			int N = Integer.parseInt(sc.nextLine());
			HashMap<String,Team> kv = new HashMap<>();
			//记录球队名字
			for(int n= 0;n<N;n++) {
				String name = sc.nextLine();
				kv.put(name, new Team(name));
			}
			//比分行数
			int rows = N*(N-1)>>1;
			for(int row=0;row<rows;row++) {
				String[] arr = sc.nextLine().split(" ");
				String[] names = arr[0].split("-");
				String[] values = arr[1].split(":");
				
				String namea = names[0];
				String nameb = names[1];
				
				int valuea = Integer.valueOf(values[0]);
				int valueb = Integer.valueOf(values[1]);
				//Integer.parseInt(s)
				int scorea = 0,scoreb = 0;
				if(valuea > valueb) {
					scorea = 3;
					scoreb = 0;
					kv.get(namea).score+=scorea;
					kv.get(namea).pure+=valuea-valueb;
					kv.get(namea).hit+=valuea;
				}else if(valuea == valueb) {
					scorea = 1;
					scoreb = 1;
					kv.get(namea).score+=scorea;
					kv.get(namea).hit+=valuea;
					kv.get(nameb).score+=scoreb;
					kv.get(nameb).hit+=valueb;
				}else {
					scorea = 0;
					scoreb = 3;
					kv.get(nameb).score+=scoreb;
					kv.get(nameb).pure+=valueb-valuea;
					kv.get(namea).hit+=valueb;
					
				}
			}
			Collection<Team> c = kv.values();
			LinkedList<Team> list = new LinkedList<>();
			for(Team t:c) {
				list.add(t);
			}
			Collections.sort(list,new Comparator<Team>() {

				@Override
				public int compare(Team o1, Team o2) {
					// TODO Auto-generated method stub
					if(o1.score != o2.score)
						return -o1.score+o2.score;
					else if(o1.pure != o2.pure)
						return -o1.pure+o2.pure;
					else
						return -o1.hit+o2.hit;
				}
				
			});
			for(int i = 0;i < N/2;i++) {
				System.out.println(list.get(i).toString());
			}

			
		}
		sc.close();
	}

}
