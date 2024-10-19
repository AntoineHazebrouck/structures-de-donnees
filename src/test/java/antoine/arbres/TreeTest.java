package antoine.arbres;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TreeTest {
	Tree TREE() {
		return new Tree(
				new Tree(null, 5, new Tree(7)),
				10,
				new Tree(15));
	}

	@Test
	void testAdd() {
		Tree tree = new Tree(new Tree(5), 10, new Tree(15));

		tree.add(5);

		assertThat(tree).isEqualTo(new Tree(new Tree(5), 10, new Tree(15)));

		tree.add(7);

		assertThat(tree).isEqualTo(TREE());

	}

	@Test
	void testToString() {
		Tree tree = TREE();

		assertThat(tree.toString()).isEqualTo("5, 7, 10, 15");
	}

	@Test
	void testRecherche() {
		assertThat(TREE().recherche(15)).isTrue();
		assertThat(TREE().recherche(10)).isTrue();
		assertThat(TREE().recherche(5)).isTrue();
		assertThat(TREE().recherche(7)).isTrue();
		assertThat(TREE().recherche(6)).isFalse();
	}

	@Test
	void testSize() {
		assertThat(TREE().size()).isEqualTo(4);
	}
}
