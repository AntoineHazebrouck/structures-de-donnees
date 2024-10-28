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

	public Tree(int value, Tree left, Tree right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public void afficheSuffixe() {
		if (left != null)
			left.afficheSuffixe();
		if (right != null)
			right.afficheSuffixe();
		System.out.println(value);
	}

	public void affichePrefixe() {
		System.out.println(value);
		if (left != null)
			left.affichePrefixe();
		if (right != null)
			right.affichePrefixe();
	}

	public void afficheInfixe() {
		if (left != null)
			left.afficheInfixe();
		System.out.println(value);
		if (right != null)
			right.afficheInfixe();
	}

	public int max() {
		if (right != null)
			return right.max();
		else
			return value;
	}

	public int sum() {
		return (left != null ? left.sum() : 0) + value + (right != null ? right.sum() : 0);
	}

	public int size() {
		return (left != null ? left.size() : 0) + 1 + (right != null ? right.size() : 0);
	}

	public int nbLeaves() {
		return (left != null ? left.nbLeaves() : 0) +
				(left == null && right == null ? 1 : 0) +
				(right != null ? right.nbLeaves() : 0);
	}

	public int hauteur() {
		return Integer.max(
				left != null ? left.hauteur() + 1 : 0,
				right != null ? right.hauteur() + 1 : 0);
	}

	public boolean recherche(int search) {
		if (search < value) {
			if (left == null)
				return false;
			return left.recherche(search);
		} else if (search > value) {
			if (right == null)
				return false;
			return right.recherche(search);
		} else {
			return true;
		}
	}

	@Override
	public boolean equals(Object obj) {
		Tree other = (Tree) obj;

		return (this.left != null && other.left != null ? left.equals(other.left) : true) && 
		this.value == other.value && 
		(this.right != null && other.right != null ? right.equals(other.right) : true);
	}

}
