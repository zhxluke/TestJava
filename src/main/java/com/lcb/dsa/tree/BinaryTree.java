package com.lcb.dsa.tree;

public class BinaryTree<T> {
	private Node<T> root;

	public BinaryTree(T element) {
		this.root = new Node<T>(element);
	}

	public void print(Node<T> node) {
		if (node != null) {
			System.out.println(node.element);
		}
	}

	private void print() {
		inOrder(root);
	}

	private void inOrder(Node<T> node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		node.print();
		inOrder(node.right);
	}

	private static class Node<T> {
		private T element;
		private Node<T> left;
		private Node<T> right;

		Node(T element) {
			this.element = element;
		}

		void print() {
			if (element != null) {
				System.out.println(element);
			}
		}

	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>(2);
		tree.root.left = new Node<Integer>(1);
		tree.root.right = new Node<Integer>(3);

		tree.print();
	}

}
