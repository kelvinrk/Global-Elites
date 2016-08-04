package com.charles.elites.amazon.oa2;
public class TreeAmplitude {

	private static int MAX = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(100);
		root.right.right = new TreeNode(-4);;
		System.out.println(getAmplitude(root));
	}
	
	public static int getAmplitude(TreeNode root) {
		if(root == null)
			return 0;
		dfs(root, root.val, root.val);
		return MAX;
	}
	private static void dfs(TreeNode root, int min, int max) {
		if(root == null)
			return;
		min = Math.min(min, root.val);
		max = Math.max(max, root.val);
		if(root.left == null && root.right == null)
			MAX = Math.max(MAX, max - min);
		dfs(root.left, min, max);
		dfs(root.right, min, max);
	}

}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;
	
	public TreeNode(int x) {
		this.val = x;
	}
}
