package com.lcb.ds.linkedlist;

public class SinglyLinkedList<T> {

	/**
	 * 头结点不保存数据
	 */
	private Node<T> head;

	private int length;

	public SinglyLinkedList() {
		this.head = new Node<T>(null);
		this.length = 0;
	}

	/**
	 * 添加元素到链表头部
	 * 
	 * @param element
	 */
	public void addHead(T element) {
		// 新建节点
		Node<T> node = new Node<T>(element);

		// 插入头结点尾部
		node.next = head.next;
		head.next = node;

		// 长度加一
		length++;
	}

	/**
	 * 链表反转
	 */
	public void reverse() {
		Node<T> newHead = new Node<T>(null);
		while (head.next != null) {
			Node<T> node = head.next;
			head.next = node.next;

			// 头结点插入
			node.next = newHead.next;
			newHead.next = node;
		}

		head = newHead;
	}

	/**
	 * 返回节点的下标
	 * 
	 * @param node
	 * @return
	 */
	public T find(int index) {
		Node<T> next = findNode(index);
		if (next != null) {
			return next.element;
		}

		return null;
	}

	/**
	 * 返回节点的下标
	 * 
	 * @param node
	 * @return
	 */
	public int index(T element) {
		int index = -1;
		if (element == null) {
			return index;
		}

		Node<T> next = head.next;
		while (next != null) {
			if (element.equals(next.element)) {
				return index + 1;
			}
			next = next.next;
			index++;
		}

		return index;
	}

	/**
	 * 在指定位置插入一个元素
	 * 
	 * @param node
	 */
	public void insert(int index, T element) {
		if (index < 0 || index > length) {
			return;
		}

		Node<T> prev = head;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}

		insert(prev, element);
	}

	/**
	 * 插入指定节点尾部
	 * 
	 * @param node
	 * @param element
	 */
	private void insert(Node<T> node, T element) {
		if (node != null) {
			// 新建节点
			Node<T> newNode = new Node<T>(element);

			newNode.next = node.next;
			node.next = newNode;

			// 长度加一
			length++;
		}
	}

	public void insert(T element) {
		if (length == 0) {
			insert(head, element);
		} else {
			insert(findNode(length - 1), element);
		}
	}

	public Node<T> findNode(int index) {
		if (index < 0 || index > length - 1) {
			return null;
		}

		Node<T> next = head.next;
		for (int i = 0; i <= index; i++) {
			if (next.next == null) {
				break;
			}
			next = next.next;
		}

		return next;
	}

	/**
	 * 删除节点
	 * 
	 * @param element
	 */
	public void remove(int index) {
		System.out.println("this is a empty method");
	}

	public void print() {
		Node<T> next = head.next;
		while (next != null) {
			int index = index(next.element);
			System.out.println(index + "-" + next.element);
			next = next.next;
		}
	}

	private static class Node<T> {
		private T element;
		private Node<T> next;

		Node(T element) {
			this.element = element;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		System.out.println("length->" + list.length);

		// list.insert(0, 7);
		// list.insert(6, 6);
		// list.insert(1, 8);

		list.print();

		list.reverse();
		list.print();
	}
}
