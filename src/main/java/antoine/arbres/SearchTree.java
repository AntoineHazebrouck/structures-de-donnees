package antoine.arbres;

import lombok.Data;

@Data
public class SearchTree {
	private final int value;
	private SearchTree left;
	private SearchTree right;

	public SearchTree(SearchTree left, int value, SearchTree right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public SearchTree(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public void add(int value) {
		if (value > this.getValue()) {
			if (this.right == null) {
				this.right = new SearchTree(value);
			} else {
				this.right.add(value);
			}
		} else if (value < this.getValue()) {
			if (this.left == null) {
				this.left = new SearchTree(value);
			} else {
				this.right.add(value);
			}
		}
	}

	public boolean recherche(int value) {
		if (value > this.value) {
			return (right != null) ? right.recherche(value) : false;
		} else if (value < this.value) {
			return (left != null) ? left.recherche(value) : false;
		} else {
			return value == this.value;
		}
	}

	public void supprimer(int value) {
		if ()
	}
}
