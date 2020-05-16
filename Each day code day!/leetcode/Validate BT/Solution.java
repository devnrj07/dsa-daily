import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Solution{
    public static void main(String[] args) {
        
    }

    /* static boolean validateBT(TreeNode root){

    } */

    //inorder traversal left > root > right
    static boolean isBinaryTree(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        double inorder = - Double.MAX_VALUE;

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= inorder) return false;
            inorder = root.val;
            root = root.right; // traverse to the right
        }
    }
}