package antoine.arbres;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SearchTreeTest {
	SearchTree TREE() {
		return new SearchTree(
				new SearchTree(10),
				20,
				new SearchTree(
						new SearchTree(25),
						30,
						new SearchTree(35)));
	}

	@Test
	void testAdd() {
		SearchTree tree = new SearchTree(20);
		tree.add(10);
		tree.add(30);
		tree.add(25);
		tree.add(35);

		assertThat(TREE()).isEqualTo(tree);
	}

	@Test
	void testRecherche() {
		assertThat(TREE().recherche(10)).isTrue();
		assertThat(TREE().recherche(20)).isTrue();
		assertThat(TREE().recherche(25)).isTrue();
		assertThat(TREE().recherche(30)).isTrue();
		assertThat(TREE().recherche(35)).isTrue();
		assertThat(TREE().recherche(21)).isFalse();
		assertThat(TREE().recherche(5)).isFalse();
		assertThat(TREE().recherche(100)).isFalse();
	}

}
