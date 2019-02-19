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

class Node {
	private Comparable data;
	private Node left;
	private Node right;

	public Node(Comparable data) {
		this.data = data;
	}

	public void addNode(Node newNode) {
		if (newNode.data.compareTo(data) < 0) {
			if (left == null) {
				left = newNode;
			} else {
				left.addNode(newNode);
			}
		} else {
			if (right == null) {
				right = newNode;
			} else {
				right.addNode(newNode);
			}
		}
	}

	public void printNode() {
		if (left != null) {
			left.printNode();
		}

		System.out.println(data + "\t");

		if (right != null) {
			right.printNode();
		}
	}
}

public class BinaryTree {
	private Node root;

	public void add(Comparable data) {
		Node newNode = new Node(data);

		if (root == null) {
			root = newNode;
		} else {
			root.addNode(newNode);
		}
	}

	public void print() {
		root.printNode();
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();

		bt.add(7);
		bt.add(21);
		bt.add(18);
		bt.add(16);
		bt.add(9);
		bt.add(20);
		bt.add(2);
		bt.add(0);
		bt.add(11);
		bt.add(13);

		bt.print();
	}
}
