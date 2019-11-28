package com.lcb.dsa.array;

public class Array {
	// 保存数据
	private int[] values;
	// 数组容量
	private int capacity;
	// 已占用数组个数
	private int count;

	public Array(int capacity) {
		this.values = new int[capacity];
		this.capacity = capacity;
		// 刚创建时，已占用数组个数为0
		this.count = 0;
	}

	/**
	 * @return
	 */
	public int[] getValues() {
		return values;
	}

	/**
	 * 随机访问指定位置的元素
	 * 
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public int find(int index) throws Exception {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("count=" + count + ", index="
					+ index);
		}

		return values[index];
	}

	/**
	 * @param index
	 * @param value
	 * @return
	 */
	public boolean insert(int index, int value) {
		if (count == capacity) {
			return false;
		}

		if (index < 0 || index > count) {
			return false;
		}

		for (int i = count; index < i; i--) {
			values[i] = values[i - 1];
		}

		values[index] = value;
		count++;

		return true;
	}

	/**
	 * @param index
	 * @return
	 */
	public boolean delete(int index) {
		if (index < 0 || index >= count) {
			return false;
		}

		for (int i = index; i < count; i++) {
			values[i] = values[i + 1];
		}

		count--;

		return true;
	}

	/**
	 * 打印整个数组
	 */
	public void printAll() {
		System.out.print("[");
		for (int i = 0; i < count; i++) {
			System.out.print(values[i]);
			if (i < count - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		Array array = new Array(10);
		array.insert(0, 0);
		array.insert(1, 1);
		array.insert(2, 2);
		array.insert(3, 3);
		array.insert(4, 4);
		array.printAll();

		array.delete(0);
		array.printAll();

		array.delete(4);
		array.printAll();

		array.delete(3);
		array.printAll();

		array.delete(1);
		array.printAll();
	}

}
