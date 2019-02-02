/*
*
* 链表是一种数据结构，和数组同级。
*
* Java中我们使用的ArrayList，其实现原理是数组, 数组是一种连续存储线性结构，元素类型相同，大小相等.
* 而LinkedList的实现原理就是链表了, 链表是离散存储线性结构。链表在进行循环遍历时效率不高，但是插入和删除时优势明显， 空间没有限制。
*
* n个节点离散分配，彼此通过指针相连，每个节点只有一个前驱节点，每个节点只有一个后续节点，首节点没有前驱节点，尾节点没有后续节点。
*
* 单项链表
*
	* 单向链表是一种线性表，实际上是由节点（Node）组成的，一个链表拥有不定数量的节点。
	* 其数据在内存中存储是不连续的，它存储的数据分散在内存中，每个结点只能也只有它能知道下一个结点的存储位置。
	* 由N各节点（Node）组成单向链表，每一个Node记录本Node的数据及下一个Node。向外暴露的只有一个头节点（Head），
	* 我们对链表的所有操作，都是直接或者间接地通过其头节点来进行的。
*
*
* Head -> Object | Quote -> Object | Quote -> .......
*
*  上边最左边的节点即为头结点（Head）， 它不存放任何的数据；指示充当一个指向链表中真正存放数据的第一个节点
*  但是添加节点的顺序是从右往左的，添加的新节点会被作为新节点。
*  最先添加的节点对下一节点的引用可以为空。引用是引用下一个节点而给下一个节点对象。因为有着不断的引用，
*  所有头结点就可以操作所有的节点了。
*  就这样一节一节往下面记录，知道最后一个节点，其中的next指向null.
*
*
*  单向链表的存储是分散的，每一个节点只要记录下一节点，就把所有的数据串了起来，形成一个单向链表
*
*  memoryAddress  data   next
*   1000          123    1002
*   1001
*   1002          222    1003
*   1003          789    1005
*   1004
*   1005          111    ^
*   1006
*
*
* 节点(Node) 是由一个需要存储的对象以及对下一个节点的引用组成的。
* 也就是说，节点拥有两个成员： 存储的对象，对下一个节点的引用。
*
* node_1
* data    Node.next
* "123"   node_2
*
* node_2
*  data   Node.next
* "222"    node_3
*  .
*  .
*  .
*
*  头部插入建立方式的思想是,首先建立一个指针，
	1.然后新建第一个节点，让指针指向这个节点
	2.然后再新建一个节点，通过指针拿到第一个点的地址，让新建的下一个地址指向第一个节点。
	3.最后把指针移动到第一个节点上。
	后面重复这个过程就可以
*
* */

// node
class Node
{
	public int data;
	public Node next;

	public Node(int data) {
		this.data = data;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}

// LinkedList
class LinkedListOperate
{
	Node head = null;

	// add
	public void addNode(int d) {
		Node newNode = new Node(d);

		if (head == null) {
			head = newNode;
			return;
		}

		Node tmp = head;
		while(tmp.next != null) {
			tmp = tmp.next;
		}

		tmp.next = newNode;
	}

	// delete node
	public boolean deleteNode(int index) {
		if (index < 1 || index > length()) {
			return false;
		}

		if (index == 1) {
			head = head.next;
			return true;
		}

		int i = 1;
		Node preNode = head;
		Node curNode = preNode.next;

		while(curNode != null) {
			if (i == index) {
				preNode.next = curNode.next;
				return true;
			}

			preNode = curNode;
			curNode = curNode.next;
			i++;
		}

		return false;
	}

	// node length
	public int length() {
		int length = 0;
		Node tmp = head;

		while(tmp != null) {
			length++;
			tmp = tmp.next;
		}

		return length;
	}

	// delete oneself node
	public boolean deleteNodeOne(Node n) {
		if (n == null || n.next == null) {
			return false;
		}

		int tmp = n.data;
		n.data = n.next.data;
		n.next.data = tmp;
		n.next = n.next.next;

		System.out.println("delete success." + n);
		return true;
	}

	public void printList() {
		Node tmp = head;

		while(tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
}

public class LinkedListSingle
{
	public void operateLinkedList() {
		LinkedListOperate llo = new LinkedListOperate();

		llo.addNode(5);
		llo.addNode(4);
		llo.addNode(2);
		llo.addNode(1);

		System.out.println("linkedList: " + llo.length());
		System.out.println("head.data: " + llo.head.data);

		llo.printList();

		llo.deleteNode(3);

		System.out.println("After deleteNode(3)");

		llo.printList();
	}

	public static void main(String[] args) {
		LinkedListSingle lls = new LinkedListSingle();

		lls.operateLinkedList();
	}
}
