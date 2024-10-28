package antoine.arbres;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TreeTest {
	Tree TREE() {
		// Tree tree = new Tree(20);
		Tree sag = new Tree(5, new Tree(3, null, null),
				new Tree(12, new Tree(8, new Tree(6, null, null), null), new Tree(13, null, null)));
		Tree sad = new Tree(25, new Tree(21, null, null), new Tree(28, null, null));
		Tree tree = new Tree(20, sag, sad);

		return tree;
	}

	// @Test
	// void testToString() {
	// 	Tree tree = TREE();

	// 	assertThat(tree.toString()).isEqualTo("3, 5, 6, 8, 12, 13, 20, 21, 25, 28");
	// }

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

		Tree notEqual = new Tree(10, new Tree(5), new Tree(10));

		assertThat(TREE()).isNotEqualTo(notEqual);
	}

	@Test
	void testNbLeaves() {
		assertThat(TREE().nbLeaves()).isEqualTo(5);
	}

	@Test
	void testHauteur() {
		assertThat(TREE().hauteur()).isEqualTo(4);
	}
}
