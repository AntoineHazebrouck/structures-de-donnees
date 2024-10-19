package antoine.arbres;

import lombok.Data;

@Data
public class Tree {
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
}
