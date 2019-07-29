package com.lcb.dsa.linkedlist;

public class SinglyLinkedList<T> {

	/**
	 * 头结点
	 */
	private Node<T> head;

	public SinglyLinkedList() {
		this.head = new Node<T>();
	}

	/**
	 * 添加元素到链表尾部
	 * 
	 * @param element
	 */
	public void add(T element) {
		Node<T> newNode = new Node<T>();
		newNode.setElement(element);

		// 查找链表尾部节点
		Node<T> next = head;
		while (next.next != null) {
			next = next.next;
		}

		// 添加到尾部节点
		next.setNext(newNode);
	}

	/**
	 * 删除节点
	 * 
	 * @param element
	 */
	public void delete(Node<T> node) {

	}

	/**
	 * 删除节点
	 * 
	 * @param element
	 */
	public void delete(int index) {

	}

	/**
	 * 插入元素
	 * 
	 * @param element
	 */
	public void insert(T element) {

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
			System.out.println(next.getElement());
			next = next.next;
		}
	}
}
