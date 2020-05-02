
/* Given a non-empty binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 The path must contain at least one node and does not need to go through the root.*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxSum;
    }
    
    private int maxSum(TreeNode root){
        if(root == null) return 0;
        
        int leftSum = Math.max(0,maxSum(root.left));
        int rightSum = Math.max(0,maxSum(root.right));
        
        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);
        
        /* This problem maximum has 4 situation: 1)pick root 2)pick left branch 3) pick right branch 4) pick branch go through root with positive left branch and right branch.
        maxSum = Math.max(maxSum,Math.max(rightSum,leftSum));       //pick left branch or right branch
        maxSum = Math.max(maxSum,root.val);                   //pick root
        maxSum = Math.max(maxSum,root.val+Math.max(0,leftSum)+ Math.max(0,rightSum)); // pick root + MAX(0,left) + MAX(0,right) //compare with zero to ignore negative value branches
        */
    
        return root.val+Math.max(leftSum,rightSum);
    }
}