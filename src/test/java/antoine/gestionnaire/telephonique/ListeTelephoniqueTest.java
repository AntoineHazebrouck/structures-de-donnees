package antoine.gestionnaire.telephonique;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ListeTelephoniqueTest {
	final ListeTelephonique LISTE = new ListeTelephonique(
		new ElementTelephonique("Antoine", "06"), 
		new ListeTelephonique(
			new ElementTelephonique("Eliso", "07"),
			new ListeTelephonique(
				new ElementTelephonique("Caca", "08")
			)
		)
	);

	@Test
	void testToString() {
		assertThat(LISTE).hasToString("[ElementTelephonique(nom=Antoine, telephone=06), ElementTelephonique(nom=Eliso, telephone=07), ElementTelephonique(nom=Caca, telephone=08)]");
	}

	@Test
	void testSize() {
		ListeTelephonique oneElement = new ListeTelephonique(new ElementTelephonique("Caca", "06"));

		assertThat(oneElement.size()).isEqualTo(1);
		assertThat(LISTE.size()).isEqualTo(3);
	}
}
