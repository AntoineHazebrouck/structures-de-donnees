package antoine.gestionnaire.telephonique;

import java.util.Iterator;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ListeTelephonique implements Iterable<ListeTelephonique> {
	private final ElementTelephonique element;
	private Optional<ListeTelephonique> suivant;

	public ListeTelephonique(ElementTelephonique element) {
		this.element = element;
		this.suivant = Optional.empty();
	}

	public ListeTelephonique(ElementTelephonique element, ListeTelephonique suivant) {
		this.element = element;
		this.suivant = Optional.of(suivant);
	}

	public ListeTelephonique addFirst(ElementTelephonique element) {
		return new ListeTelephonique(element, this);
	}

	public ListeTelephonique addLast(ElementTelephonique element) {
		if (suivant.isEmpty()) {
			suivant = Optional.of(new ListeTelephonique(element));
		} else {
			Iterator<ListeTelephonique> iterator = iterator();
			ListeTelephonique current = null;
			while (iterator.hasNext()) {
				current = iterator.next();
			} ;
			current.suivant = Optional.of(new ListeTelephonique(element));
		}
		return this;
	}

	public Optional<ListeTelephonique> recherche(String nom) {
		Optional<ListeTelephonique> value = Optional.empty();

		for (ListeTelephonique node : this) {
			if (node.element.getNom().equals(nom)) value = Optional.of(node);
		}

		return value;
	}

	public int size() {
		int count = 1;

		for (ListeTelephonique node : this) {
			count++;
		}

		return count;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[" + element);

		for (ListeTelephonique node : this) {
			builder.append(", " + node.element);
		}

		return builder.toString() + "]";
	}

	@Override
	public Iterator<ListeTelephonique> iterator() {
		return new ListeIterator(this);
	}

	@AllArgsConstructor
	private final class ListeIterator implements Iterator<ListeTelephonique> {
		private ListeTelephonique current;

		@Override
		public boolean hasNext() {
			return current.suivant.isPresent();
		}

		@Override
		public ListeTelephonique next() {
			current = current.suivant.get();
			return current;
		}
	}
}
