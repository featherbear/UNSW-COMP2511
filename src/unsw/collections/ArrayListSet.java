/**
 *
 */
package unsw.collections;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An implementation of Set that uses an ArrayList to store the elements.
 *
 * @invariant All e in elements occur only once
 *
 * @author Robert Clifton-Everest
 *
 */
public class ArrayListSet<E> implements Set<E> {

	private ArrayList<E> elements;

	public ArrayListSet() {
		elements = new ArrayList<>();
	}

	@Override
	public void add(E e) {
		if (this.elements.contains(e)) {
			return;
		}

		this.elements.add(e);
	}

	@Override
	public void remove(E e) {
		elements.remove(e);
	}

	@Override
	public boolean contains(Object e) {
		return elements.contains(e);
	}

	@Override
	public int size() {
		return elements.size();
	}

	@Override
	public boolean subsetOf(Set<?> other) {
		for (E e : this.elements) {
			if (!other.contains(e)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return this.elements.iterator();
	}

	@Override
	public Set<E> union(Set<? extends E> other) {
		ArrayListSet<E> result = new ArrayListSet<E>();
		for (E e : this) {
			result.add(e);
		}

		for (E e : other) {
			result.add(e);
		}

		return result;
	}

	@Override
	public Set<E> intersection(Set<? extends E> other) {
		ArrayListSet<E> result = new ArrayListSet<E>();
		for (E e : this) {
			if (other.contains(e)) {
				result.add(e);
			}
		}

		return result;
	}

	/**
	 * For this method, it should be possible to compare all other possible sets for
	 * equality with this set. For example, if an ArrayListSet<Fruit> and a
	 * LinkedListSet<Fruit> both contain the same elements they are equal.
	 * Similarly, if a Set<Apple> contains the same elements as a Set<Fruit> they
	 * are also equal.
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (other == this) {
			return true;
		}
		if (!(other instanceof Set)) {
			return false;
		}

		Set<?> otherSet = (Set<?>) other;

		if (this.size() != otherSet.size()) {
			return false;
		}

		if (!this.contains(otherSet)) {
			return false;
		}

		if (!otherSet.contains(this)) {
			return false;
		}

		return true;
	}

}
