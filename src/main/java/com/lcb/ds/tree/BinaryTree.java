package com.lcb.ds.tree;

public class BinaryTree<T extends Comparable<T>> implements Comparable<T> {
	private TreeNode<T> root;

	public BinaryTree(T element) {
		this.root = new TreeNode<T>(element);
	}

	public TreeNode<T> getRoot() {
		return root;
	}

	public void add(T element) {
		addElement(root, element);
	}

	private void addElement(TreeNode<T> node, T element) {
		if (element.compareTo(node.getElement()) == 0) {
			return;
		}
		if (element.compareTo(node.getElement()) < 0) {
			if (node.getLeft() != null) {
				addElement(node.getLeft(), element);
			} else {
				node.setLeft(new TreeNode<T>(element));
			}
		} else {
			if (node.getRight() != null) {
				addElement(node.getRight(), element);
			} else {
				node.setRight(new TreeNode<T>(element));
			}
		}
	}

	private void inOrder(TreeNode<T> node) {
		if (node == null) {
			return;
		}

		inOrder(node.getLeft());
		System.out.println(node.getElement());
		inOrder(node.getRight());
	}

	@Override
	public int compareTo(T o) {
		return this.compareTo(o);
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>(5);
//		tree.root.setLeft(new TreeNode<Integer>(1));
//		tree.root.setRight(new TreeNode<Integer>(3));
		
		tree.add(1);
		tree.add(3);
		tree.add(6);
		tree.add(7);
		tree.add(9);

		tree.inOrder(tree.getRoot());

	}

}
