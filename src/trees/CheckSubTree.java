package trees;


public class CheckSubTree {

	
	public static void main(String[] args) {
		TreeNode root1 = createBinaryTree();
		TreeNode root2 = createBinaryTree2();
		if(checkSubTree(root1,root2)) {
			System.out.println("T2 is sub tree");
		} else {
			System.out.println("Not a sub tree");
		}
	}
	
	public static boolean checkSubTree(TreeNode root1,TreeNode root2) {
		if(root1==null && root2==null) {
			return true;
		}
		if(root1!=null && root2==null) {
			return true;
		}
		if(root1==null && root2!=null) {
			return false;
		}
		if(root1.data == root2.data) {
			return checkSubTree(root1.left, root2.left) && checkSubTree(root1.right, root2.right);
		} else {
			return checkSubTree(root1.left, root2) || checkSubTree(root1.right, root2);
		}
	}
	
	public static TreeNode createBinaryTree() {

		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);
		TreeNode node5 = new TreeNode(5);
		TreeNode node55 = new TreeNode(55);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;
		node10.left = node5;
		node50.right = node55;

		return rootNode;
	}
	
	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}
	
	public static TreeNode createBinaryTree2() {

		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);
		TreeNode node5 = new TreeNode(5);
		TreeNode node55 = new TreeNode(55);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;
		node10.left = node5;
		node50.right = node55;

		return rootNode;
	}
}
