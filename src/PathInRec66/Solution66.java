package PathInRec66;

/**
 * @author duffywang
 * @date 2018年3月18日
 * @version 1.0
 *请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 *每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 *但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *a b c e
 *s f c s
 *a d e e
 *b-c-c-e-d
 *回溯算法，递归特性，路径可以看成一个栈
 *当走到n个字符的位置时，周围都找不到n+1个字符，回到路径上n-1个字符，重新定义第n个字符
 *
 */
public class Solution66 {
	
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix == null || rows < 1 || cols < 1 || str == null)return false;
        int[] vis = new int[matrix.length];
        int k = 0;
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
            	//可以从rows*cols任意点开始第一步，只要有其中一个把路程走完就返回true
                if(hasPathCore(matrix,rows,cols,i,j,str,k,vis)){
                    return true;
                }
            }
        }
        return false;
    
    }
    private Boolean hasPathCore(char[] matrix,int rows,int cols,int i,int j,char[] str,int k,int []vis){
    	//在strz中的序号
        int index = i * cols + j;
        //越界 、 不相等 、 走过
        if(i < 0 || i >= rows || j <0 || j >= cols||matrix[index] != str[k] || vis[index] == 1)
            return false;
        //走完全路程
        if(k == str.length-1)return true;
        //假设要走这个点，以后不能再用了，
        vis[index] = 1;
        if(hasPathCore(matrix,rows,cols,i+1,j,str,k+1,vis)||
          hasPathCore(matrix,rows,cols,i,j+1,str,k+1,vis)||
            hasPathCore(matrix,rows,cols,i,j-1,str,k+1,vis)||
           hasPathCore(matrix,rows,cols,i-1,j,str,k+1,vis)){
             return true;
        }
        //实际上没用这个点，以后还可以再用
        vis[index] = 0;
        return false;
           
            
            
    }

}
