public class Solution {
    public static void main(String[] args) {
        
    }
    static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++){
            root = insert(root, preorder[i]);
        }
        return root;
    }
    //recursice approach
    static TreeNode insert(TreeNode root, int value){
        if( root == null) return new TreeNode(value);

        if(value < root.value){
            root.left = insert(root.left,value);
        }else{
            root.right = insert(root.right, value);
        }
        return root;
    }

    //iterative approach
    static void insertIterative(TreeNode root, int value){

        TreeNode newNode = new TreeNode(value);
        while(root != null){

            if(value < root.value){
                if(root.left ==null){
                    root.left = newNode;
                    break;
                }else{
                    root = root.left;
                }
            }else if(value > root.value){
                if(root.right == null){
                    root.right = newNode;
                    break;
                }else{
                    root = root.right;
                }
            }
        }
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ this.value = x;}
}