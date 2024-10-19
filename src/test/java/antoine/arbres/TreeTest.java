package antoine.arbres;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TreeTest {
	@Test
	void testAdd() {
		Tree tree = new Tree(new Tree(5), 10, new Tree(15));

		tree.add(5);

		assertThat(tree).isEqualTo(new Tree(new Tree(5), 10, new Tree(15)));

		tree.add(7);

		assertThat(tree).isEqualTo(
				new Tree(
						new Tree(null, 5, new Tree(7)),
						10,
						new Tree(15)));

	}
}
