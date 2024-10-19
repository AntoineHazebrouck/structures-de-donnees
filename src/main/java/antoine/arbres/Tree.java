package antoine.arbres;

import java.util.Iterator;

import lombok.Data;

@Data
public class Tree implements Iterable<Integer> {
	private final int value;
	private Tree left;
	private Tree right;

	public Tree(int value) {
		this.value = value;
		left = null;
		right = null;
	}

	public Tree(Tree left, int value, Tree right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public int sum() {
		return (left != null ? left.sum() : 0) + value + (right != null ? right.sum() : 0);
	}

	public int size() {
		return (left != null ? left.size() : 0) + 1 + (right != null ? right.size() : 0);
	}

	public boolean recherche(int search) {
		if (search < value) {
			if (left == null) return false;
			return left.recherche(search);
		} else if (search > value) {
			if (right == null) return false;
			return right.recherche(search);
		} else {
			return true;
		}
	}

	public void add(Integer value) {
		if (this.value == value) {
			return;
		}
		if (value > this.value) {
			if (isLeaf()) {
				right = new Tree(value);
			} else {
				right.add(value);
			}
		} else if (value < this.value) {
			if (isLeaf()) {
				left = new Tree(value);
			} else {
				left.add(value);
			}
		}
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	@Override
	public String toString() {
		return (left != null ? left.toString() + ", " : "") + value + (right != null ? ", " + right.toString() : "");
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'iterator'");
	}

	// @AllArgsConstructor
	// private class TreeIterator implements Iterator<Integer> {
	// private Tree current;

	// @Override
	// public boolean hasNext() {
	// current.
	// }

	// @Override
	// public Integer next() {
	// // TODO Auto-generated method stub
	// throw new UnsupportedOperationException("Unimplemented method 'next'");
	// }

	// }
}
