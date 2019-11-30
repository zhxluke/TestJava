package com.lcb.ds.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.lcb.ds.tree.BinaryTree;
import com.lcb.ds.tree.TreeNode;

public class BreadthFirst {
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>(5);
		tree.add(1);
		tree.add(3);
		tree.add(6);
		tree.add(7);
		tree.add(9);

		
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		queue.add(tree.getRoot());

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i <= size - 1; i++) {
				TreeNode<Integer> node = queue.poll();
				System.out.print(node.getElement() + " ");
				if (node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.add(node.getRight());
				}
			}
			size = 0;
			System.out.println();
		}
	}
}
