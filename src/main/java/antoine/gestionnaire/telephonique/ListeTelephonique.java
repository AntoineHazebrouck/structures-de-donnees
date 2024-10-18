package antoine.gestionnaire.telephonique;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import lombok.Data;

@Data
public class ListeTelephonique {
	private final ElementTelephonique element;
	private final Optional<ListeTelephonique> suivant;

	public ListeTelephonique(ElementTelephonique element) {
		this.element = element;
		this.suivant = Optional.empty();
	}

	public ListeTelephonique(ElementTelephonique element, ListeTelephonique suivant) {
		this.element = element;
		this.suivant = Optional.of(suivant);
	}

	public int size() {
		final AtomicInteger count = new AtomicInteger(1);

		iterateOver(element -> count.incrementAndGet());

		return count.intValue();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[" + element);

		iterateOver(element -> builder.append(", " + element));

		return builder.toString() + "]";
	}

	private void iterateOver(Consumer<ElementTelephonique> code) {
		Optional<ListeTelephonique> next = suivant;
		while (next.isPresent()) {
			code.accept(next.get().getElement());
			next = next.get().getSuivant();
		}
	}
}
