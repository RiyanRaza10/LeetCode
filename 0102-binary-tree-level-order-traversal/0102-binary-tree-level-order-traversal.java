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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        List<Integer> base = new ArrayList<>();
        base.add(root.val);
        ans.add(base);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for(int i=0 ; i<size ; i++){
                TreeNode curr = q.poll();

                if(curr.left != null) {
                    list.add(curr.left.val);
                    q.offer(curr.left);
                }

                if(curr.right != null){
                    list.add(curr.right.val);
                    q.offer(curr.right);
                }
            }

            if(list.size() != 0) ans.add(list);    
        }

        return ans;
    }
}