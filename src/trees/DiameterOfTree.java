package trees;
public class DiameterOfTree {

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	private static int max = 0;

	public static void main(String[] args) {
		TreeNode rootNode = createBinaryTree();
		int diameter = getDiameter(rootNode);
		System.out.println(max);
	}

	public static int getDiameter(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lh = getDiameter(root.left);
		int rh = getDiameter(root.right);

		if (lh > 0 && rh > 0 && max < (lh + rh)) {
			System.out.println(lh + "  " + rh + "  " + max);
			max = lh + rh;
		}
		return Math.max(lh, rh) + 1;
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

}
