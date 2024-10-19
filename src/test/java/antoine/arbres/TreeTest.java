package antoine.arbres;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TreeTest {
	Tree TREE() {
		Tree tree = new Tree(20);
		tree.add(3);
		tree.add(5);
		tree.add(6);
		tree.add(8);
		tree.add(12);
		tree.add(13);
		tree.add(21);
		tree.add(25);
		tree.add(28);

		return tree;
	}

	@Test
	void testAdd() {
		Tree tree = new Tree(new Tree(5), 10, new Tree(15));

		tree.add(5);

		assertThat(tree).isEqualTo(new Tree(new Tree(5), 10, new Tree(15)));

		tree.add(7);

		assertThat(tree).isEqualTo(new Tree(new Tree(null, 5, new Tree(7)), 10, new Tree(15)));

	}

	@Test
	void testToString() {
		Tree tree = TREE();

		assertThat(tree.toString()).isEqualTo("3, 5, 6, 8, 12, 13, 20, 21, 25, 28");
	}

	@Test
	void testRecherche() {
		assertThat(TREE().recherche(3)).isTrue();
		assertThat(TREE().recherche(8)).isTrue();
		assertThat(TREE().recherche(20)).isTrue();
		assertThat(TREE().recherche(28)).isTrue();
		assertThat(TREE().recherche(2)).isFalse();
	}

	@Test
	void testSize() {
		assertThat(TREE().size()).isEqualTo(10);
	}

	@Test
	void testSum() {
		assertThat(TREE().sum()).isEqualTo(3 + 5 + 6 + 8 + 12 + 13 + 20 + 21 + 25 + 28);
	}

	@Test
	void testMax() {
		assertThat(TREE().max()).isEqualTo(28);
	}

	@Test
	void testEquals() {
		assertThat(TREE()).isEqualTo(TREE());

		Tree notEqual = TREE();
		notEqual.add(2);

		assertThat(TREE()).isNotEqualTo(notEqual);
	}
}
