package SerializeTree62;



import chapter18.BinaryTreeNode;

/**
 * @author duffywang
 * @date 2018年3月18日
 * @version 1.0
 *请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class problem62 {
    int index = -1;
    String Serialize(BinaryTreeNode root) {
        
        StringBuilder res = new StringBuilder();
        if(root == null){
            res.append("#");
            return res.toString();
        }
        //前序思想
        res.append(root.data+",") ;
        res.append(Serialize(root.left));
        res.append(Serialize(root.right));
        return res.toString();
  }
    BinaryTreeNode Deserialize(String str) {
        //每一次计数变量加一
        index++;
       BinaryTreeNode node = null;
       String[] arr = str.split(",");
        if(!arr[index].equals("#")){
            node = new BinaryTreeNode(Integer.valueOf(arr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        //若碰到#情况 则返回null
        return node;
  }

}
