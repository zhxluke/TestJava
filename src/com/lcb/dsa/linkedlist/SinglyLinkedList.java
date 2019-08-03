package com.lcb.dsa.linkedlist;

public class SinglyLinkedList<T> {

	/**
	 * 头结点不保存数据
	 */
	private Node<T> head;

	public SinglyLinkedList() {
		this.head = new Node<T>();
	}

	/**
	 * 添加元素到链表头部
	 * 
	 * @param element
	 */
	public void add(T element) {
		// 新建节点
		Node<T> node = new Node<T>();
		node.setElement(element);

		// 插入链表头部
		node.setNext(head.next);
		head.setNext(node);
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

		Node<T> next = head;
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
	 * 在节点之前插入
	 * 
	 * @param node
	 */
	public void insert(int index, T element) {
		Node<T> next = findNode(index);

		while (next.next != null) {
			next = next.next;
		}
	}

	public Node<T> findNode(int index) {
		int i = -1;

		if (index < i) {
			return null;
		}

		Node<T> next = head;
		while (next != null) {
			if (index == i) {
				break;
			}
			next = next.next;
			i++;
		}

		if (next != null) {
			return next;
		}

		return null;
	}

	/**
	 * 删除节点
	 * 
	 * @param element
	 */
	public void remove(int index) {

	}

	public static class Node<T> {
		private T element;
		private Node<T> next;

		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		Node<Integer> next = list.head;
		while (next != null) {
			int index = list.index(next.element);
			Integer element = list.find(index);

			System.out.println(index + "-" + element);

			next = next.next;
		}

	}
}
