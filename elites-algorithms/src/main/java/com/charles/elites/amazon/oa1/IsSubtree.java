package com.charles.elites.amazon.oa1;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class IsSubtree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(5);
		t1.left = new TreeNode(3);
		t1.left.left = new TreeNode(2);
		t1.left.right = new TreeNode(4);
		t1.right = new TreeNode(6);
		
		TreeNode t2 = new TreeNode(3);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(4);
		
		System.out.println(isSubstree(t1, t2));
	}
	
	public static boolean isSubstree(TreeNode t1, TreeNode t2) {
//		if(t2 == null)
//			return true;
//		if(t1 == null)
//			return false;
		if(isSame(t1, t2))
			return true;
		return isSubstree(t1.left, t2) || isSubstree(t1.right, t2);
	}
	
	private static boolean isSame(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null)
			return true;
		if(t1 == null || t2 == null)
			return false;
		if(t1.val != t2.val)
			return false;
		return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);  
	}
}
