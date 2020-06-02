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
    public TreeNode invertTree(TreeNode root) 
    {
        if(root==null)
        {
            return root;
        }
        //Think of this as a swap problem where we have to swap nodes of every parent
        TreeNode temp=root.left;//I am using here the same technique I will swap node of each parent while going  top down
        root.left=root.right;
        root.right=temp;
        
        //After swapping traverse to the left subtree and right subtree. 
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}