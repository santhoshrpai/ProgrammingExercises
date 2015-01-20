package trees;
public class ZigZagTree {

	public static class Stack {
		private int maxSize = 200000;
		private int current = -1;
		private TreeNode[] stack = new TreeNode[maxSize];

		public TreeNode pop() {
			return stack[current--];
		}

		public void push(TreeNode node) {
			stack[++current] = node;
		}

		public boolean isEmpty() {
			return (current == -1);
		}
	}

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		TreeNode rootNode = createBinaryTree();
		System.out.println("Zigzag traversal of binary tree :");
		zigZag(rootNode);
	}

	public static void zigZag(TreeNode root) {
		Stack stack = new Stack();
		stack.push(root);
		boolean flag = false;
		while (!stack.isEmpty()) {
			Stack tempStack = new Stack();
			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				System.out.print(node.data + " ");
				if (flag) {
					if (node != null) {
						if (node.right != null) {
							tempStack.push(node.right);
						}
						if (node.left != null) {
							tempStack.push(node.left);
						}
					}
				} else {
					if (node != null) {
						if (node.left != null) {
							tempStack.push(node.left);
						}
						if (node.right != null) {
							tempStack.push(node.right);
						}
					}
				}
			}
			flag = !flag;
			stack = tempStack;
			System.out.println();
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

}
