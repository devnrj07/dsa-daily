public class Solution{
    public static void main(String[] args) {
        
    }

    /*The idea is to DFS the tree or preorder traversal and compare with arr items, if all the items in arr match the traversal ➕ 
        the last node which matches arr[l-1] is leaf node then its a valid sequence.
        case 1 : node.val != arr[pos] or it has reached the end
        case 2 : 
        case 3 : node ==  leaf node && arr[index] has matched
        If current node is equal to arr[index] this means 
        // that till this level path has been matched and 
        // remaining path can be either in left subtree or 
        // right subtree. 

        // we do logical OR because we need a sequence in either left subtree or right subtree not both, if anyone is false we backtrack
    */

    public boolean isValidSequence(TreeNode root, int[] arr) {
        
        int n = arr.length;
        int index = 0;

        if(root == null){
            return (n == 0);
        }

        return isValidSubTree(root, arr, n, index);
    }

    public boolean isValidSubTree(TreeNode root,int[]arr, int n, int index){

        // If root is NULL or reached end of the array 
        if(root == null || index == n){
            return false;
        }

        //node has reached end i.e leaf node
        if(root.left == null & root.right == null){
            //then check if curr Node value == arr[index] value && we're under the bound of array
            if(root.val == arr[index] && (index == n-1)){
                return true;
            }
          return false;  
        }

        // curr Node value matches the arr[index] so far and now next value is either on left or right side
        return ((index < n) && (root.val == arr[index])  && (isValidSubTree(root.left, arr,n,index+1) || (isValidSubTree(root.right, arr, n, index+1))));
    }
}