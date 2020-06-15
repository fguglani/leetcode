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
    public TreeNode searchBST(TreeNode root, int val) 
    {
        //We just need to make sure which part of the tree we should be traversing 
        if(root==null)return null;//If we reach bottom then return null
        if(root.val==val)return root;//if we get the value return its substree
        if(root.val>val)return searchBST(root.left,val);//If our root is bigger than value we should traverse left subtree
        if(root.val<val)return searchBST(root.right,val);//If our root is smaller we should traverse right subtree
        return null;//If we dont find value return null
    }
}