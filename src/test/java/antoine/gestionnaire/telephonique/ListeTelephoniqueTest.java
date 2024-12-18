package antoine.gestionnaire.telephonique;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ListeTelephoniqueTest {
	private ListeTelephonique LISTE() {
		return new ListeTelephonique(
				new ElementTelephonique("Antoine", "06"),
				new ListeTelephonique(
						new ElementTelephonique("Eliso", "07"),
						new ListeTelephonique(
								new ElementTelephonique("Caca", "08"))));
	}

	@Test
	void testToString() {
		assertThat(LISTE()).hasToString(
				"[ElementTelephonique(nom=Antoine, telephone=06), ElementTelephonique(nom=Eliso, telephone=07), ElementTelephonique(nom=Caca, telephone=08)]");
	}

	@Test
	void testSize() {
		ListeTelephonique oneElement = new ListeTelephonique(new ElementTelephonique("Caca", "06"));

		assertThat(oneElement.size()).isEqualTo(1);
		assertThat(LISTE().size()).isEqualTo(3);
	}

	@Test
	void testRecherche() {
		assertThat(LISTE().recherche("Caca")).isPresent().contains(new ListeTelephonique(
				new ElementTelephonique("Caca", "08")));
	}

	@Test
	void testAddFirst() {
		var oneElement = new ListeTelephonique(new ElementTelephonique("Caca", "06"));
		var eliso = new ElementTelephonique("Eliso", "07");

		assertThat(oneElement.addFirst(eliso)).isEqualTo(new ListeTelephonique(eliso, oneElement));
	}

	@Test
	void testAddLast() {
		var oneElement = new ListeTelephonique(new ElementTelephonique("Caca", "06"));
		var eliso = new ElementTelephonique("Eliso", "07");

		assertThat(oneElement.addLast(eliso)).isEqualTo(new ListeTelephonique(
				new ElementTelephonique("Caca", "06"),
				new ListeTelephonique(eliso)));
	}

	@Test
	void testRemove() {
		assertThat(LISTE().remove("Eliso")).isEqualTo(
				new ListeTelephonique(
						new ElementTelephonique("Antoine", "06"),
						new ListeTelephonique(
								new ElementTelephonique("Caca", "08"))));

		assertThat(LISTE().remove("Antoine")).isEqualTo(
				new ListeTelephonique(
						new ElementTelephonique("Eliso", "07"),
						new ListeTelephonique(
								new ElementTelephonique("Caca", "08"))));

		assertThat(LISTE().remove("Caca")).isEqualTo(
				new ListeTelephonique(
						new ElementTelephonique("Antoine", "06"),
						new ListeTelephonique(
								new ElementTelephonique("Eliso", "07"))));
	}
}
