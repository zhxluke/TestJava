package com.lcb.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
	private TreeNode<T> root;

	public BinaryTree(T element) {
		this.root = new TreeNode<T>(element);
	}

	public void print(TreeNode<T> node) {
		if (node != null) {
			System.out.println(node.element);
		}
	}

	private void print() {
		inOrder(root);
	}

	private void inOrder(TreeNode<T> node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		node.print();
		inOrder(node.right);
	}

	private static class TreeNode<T> {
		private T element;
		private TreeNode<T> left;
		private TreeNode<T> right;

		TreeNode(T element) {
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
		tree.root.left = new TreeNode<Integer>(1);
		tree.root.right = new TreeNode<Integer>(3);

		tree.print();
		
		Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
	}

}
