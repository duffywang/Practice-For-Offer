package PrintTree60;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import chapter18.BinaryTreeNode;

/**
 * @author duffywang
 * @date 2018年3月17日
 * @version 1.0
 *从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class problem60 {
    ArrayList<ArrayList<Integer> > Print(BinaryTreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null )return res;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(pRoot);
        int start = 0,end = 1;
        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            list.add(node.data);
            start++;
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
            //每行 控制添加时间
            if(start == end){
                end = queue.size();
                start = 0;
                res.add(list);
                list = new ArrayList<Integer>();
            }
            
        }
        return res;
        
    }

}
