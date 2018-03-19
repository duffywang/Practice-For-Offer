package PrintTreeUniq61;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import chapter18.BinaryTreeNode;

public class problem61 {
	
	/**{8,6,10,5,7,9,11}->[[8],[10,6],[5,7,9,11]]
	 * ME:[[8],[10,6],[9,11,5,7]]
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> print(BinaryTreeNode root){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(root == null)return res;
		int start = 0,end = 1;
		Queue<BinaryTreeNode> queue = new LinkedList<>();  
		Stack<BinaryTreeNode> stack = new Stack<>();
		queue.offer(root);
		while(!queue.isEmpty()||!stack.isEmpty()) {
			if(!queue.isEmpty()) {
				BinaryTreeNode qNode = queue.poll();
				start++;
				list.add(qNode.data);
				if(qNode.left != null)stack.push(qNode.left);
				if(qNode.right != null)stack.push(qNode.right);
				if(start == end) {
					end = stack.size();
					start = 0;
					res.add(list);
					list = new ArrayList<Integer>();
				}
			}while(!stack.isEmpty()) {
				BinaryTreeNode sNode = stack.pop();
				start++;
				list.add(sNode.data);
				if(sNode.left != null)queue.offer(sNode.left);
				if(sNode.right != null)queue.offer(sNode.right);
				if(start == end) {
					end = queue.size();
					start = 0;
					res.add(list);
					list = new ArrayList<Integer>();
				}
				
			}
			
		}
		
		
		return res;
	}
	
	/**用两个栈，每次加入不同的栈中
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> print2(BinaryTreeNode root){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		if(root == null)return res;
		int layer = 1;
		Stack<BinaryTreeNode> s1 = new Stack<>();
		s1.push(root);
		Stack<BinaryTreeNode> s2 = new Stack<>();
		
		while(!s1.isEmpty()||!s2.isEmpty()) {
			if(layer%2 != 0) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				while(!s1.isEmpty()) {
					BinaryTreeNode node = s1.pop();
					if(node != null) {
						list.add(node.data);
						System.out.println(node.data+" ");
						s2.push(node.left);
						s2.push(node.right);
					}
				}
				if(!list.isEmpty()) {
					res.add(list);
					layer++;
					System.out.println();
				}
			}else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				while(!s2.isEmpty()) {
					BinaryTreeNode node = s2.pop();
					if(node != null) {
						list.add(node.data);
						System.out.println(node.data+" ");
						s1.push(node.right);
						s1.push(node.left);
					}
				}if(!list.isEmpty()) {
					res.add(list);
					layer++;
					System.out.println();
				}
			}
		}
		return res;
		
		
		
	}

}
