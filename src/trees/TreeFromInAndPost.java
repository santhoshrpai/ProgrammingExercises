package trees;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeFromInAndPost {

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
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

	static List<Integer> inOrder = new ArrayList<Integer>();
	static List<Integer> postOrder = new ArrayList<Integer>();

	public static void main(String[] args) {
		TreeNode root = createBinaryTree();
		inOrder(root);
		postOrder(root);
		Iterator<Integer> iter = inOrder.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		iter = postOrder.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		TreeNode newRoot = buildTree(inOrder.toArray(new Integer[inOrder.size()]), 0, inOrder.size() - 1, postOrder.toArray(new Integer[postOrder.size()]), 0, postOrder.size() - 1);
		printTree(newRoot);
	}

	public static void inOrder(TreeNode root) {
		if (root == null) {
			return;
		} else {
			if (root.left != null)
				inOrder(root.left);
			inOrder.add(root.data);
			if (root.right != null)
				inOrder(root.right);
		}
	}

	public static void postOrder(TreeNode root) {
		if (root == null) {
			return;
		} else {
			if (root.left != null)
				postOrder(root.left);
			if (root.right != null)
				postOrder(root.right);
			postOrder.add(root.data);
		}
	}
	
	public static void printTree(TreeNode root) {
		if (root == null) {
			return;
		} else {
			System.out.print(root.data+" ");
			if (root.left != null)
				printTree(root.left);
			if (root.right != null)
				printTree(root.right);
		}
	}
	
	public static TreeNode buildTree(Integer[] in, int inStart, int inEnd, Integer[] post, int postStart, int postEnd) {
		if(postStart<0 || postStart>postEnd || inStart>inEnd) {
			return null;
		}
		int rootvalue = post[postEnd];
		TreeNode root = new TreeNode(rootvalue);
		int i=0;
		for(i=0;i<in.length;i++) {
			if(in[i]==rootvalue) {
				break;
			}
		}
		root.left = buildTree(in, inStart, i-1, post, postStart, postStart+i-(inStart+1));
		root.right = buildTree(in, i+1, inEnd, post, postStart+i-inStart, postEnd-1);
		return root;
	}

}
