/*
* 树是一个非空的有限元素的集合，其中一个元素为根，余下的元素组成的子树。
* 树是一种非线性的数据结构
*
* 二叉树   Binary Tree
* 二叉树是n个节点组成的有限集合...
* 二叉树是递归定义的。
* 主要采用链式存储结构
*
*
	* 斜树
	*   所有的节点都只有左子树，或者右子树
	*
	* 完全二叉树
	*
	* 满二叉树
	*   2h-1
	*   所有的分支节点都具有左右节点
*
* 二叉树的存储结构
* 顺序存储结构
* 链式存储结构
*
* 二叉树的遍历方式
	* 前序遍历
	*   先访问根节点，然后访问左节点，最后访问右节点（根 -> 左 -> 右）
	*
	* 中序遍历
	*   左-根-右
	*
	* 后续遍历
	*   左-右-根
	*
	* 层次遍历
	*   逐层遍历
	*
	* 例子：
	*               1
	*       2               3
	*    4      5       6       7
	* 8    9  10
	*
	* 前序遍历(根-左-右)： 1-2-4-8-9-5-10-3-6-7；
	* 中序遍历(左-中-右)： 8-4-9-2-10-5-1-6-3-7；
	* 后序遍历(左-右-中)： 8-9-4-10-5-2-6-7-3-1；
	* 层次遍历(逐层遍历)： 1-2-3-4-5-6-7-8-9-10.
	*
*
*
* 度： 节点拥有的子树数； 二叉树节点的度最大为2
* 深度： 从根节点到最底层节点的层数；
* 叶子： 没有儿子的节点；
* 节点： 一个数据、两个指针(如果有节点就指向节点，没有节点就指向null)
*
*
* */

class BinaryTreeNode {
	private int data;
	private BinaryTreeNode leftChild;
	private BinaryTreeNode rightChild;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}
}

public class BinaryTree {
	private BinaryTreeNode root;

	// init binary tree
	public BinaryTree() {

	}

	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	// clear binary tree
	public void clear() {
		clear(root);
	}

	public void clear(BinaryTreeNode node) {
		if (node != null) {
			clear(node.getLeftChild());
			clear(node.getRightChild());
			node = null;
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int height() {
		return height(root);
	}

	public int height(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int l = height(node.getLeftChild());
			int r = height(node.getRightChild());
			int len = l > r ? l + 1 : r + 1;
			return len;
		}
	}

	public int size() {
		return size(root);
	}

	public int size(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + size(node.getLeftChild()) + size(node.getRightChild());
		}
	}

	public BinaryTreeNode getParent(BinaryTreeNode node) {
		return (root == null || root == null) ? null : getParent(root, node);
	}

	public BinaryTreeNode getParent(BinaryTreeNode subTree, BinaryTreeNode node) {
		if (subTree == null) {
			return null;
		}

		if (subTree.getLeftChild() == node || subTree.getRightChild() == node) {
			return subTree;
		}

		BinaryTreeNode parent = null;

		if (getParent(subTree.getLeftChild(), node) != null) {
			parent = getParent(subTree.getLeftChild(), node);
			return parent;
		} else {
			return getParent(subTree.getRightChild(), node);
		}
	}

	public BinaryTreeNode getLeftTree(BinaryTreeNode node) {
		return node.getLeftChild();
	}

	public BinaryTreeNode getRightTree(BinaryTreeNode node) {
		return node.getRightChild();
	}

	public void insertLeft(BinaryTreeNode parent, BinaryTreeNode newNode) {
		parent.setLeftChild(newNode);
	}

	public void insertRight(BinaryTreeNode parent, BinaryTreeNode newNode) {
		parent.setRightChild(newNode);
	}

	public void preOrder(BinaryTreeNode node) {
		if (node == null) {
			return;
		}

		System.out.println(node.getData());
		preOrder(node.getLeftChild());
		preOrder(node.getRightChild());
	}

	public void inOrder(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.getLeftChild());
		System.out.println(node);
		inOrder(node.getRightChild());
	}

	public void postOrder(BinaryTreeNode node) {
		if (node == null) {
			postOrder(node.getLeftChild());
			postOrder(node.getRightChild());
			System.out.println(node);
		}
	}

	public static void main(String[] args) {

	}
}
