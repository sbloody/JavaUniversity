package utility.collection;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BoundedArraySet<T> implements SetADT<T>, Serializable {

	private final static int DEFAULT_CAPACITY = 8;
	private T[] set;
	private int size;
	private boolean hasANullElement;

	public BoundedArraySet() {
		set = (T[]) new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	public String toString() {
		String s = "{";
		for (int i = 0; i < size; i++) {
			if (i < size - 1) {
				s += set[i] + ", ";
			} else {
				s += set[i];
			}

		}
		if (hasANullElement) {
			if (size > 0) {
				s += ",";
			}
			s += "null";
		}
		s += "}";
		return s;
	}

	@Override
	public Iterator<T> iterator() {

		return new BoundedArraySetIterator();
	}

	@Override
	public void add(T element) {
		if (size() >= DEFAULT_CAPACITY) {
			throw new IllegalStateException("The set is full.");
		}

		if (element == null) {
			hasANullElement = true;
			return;

		}
		if (contains(element)) {
			return;
		}
		set[size] = element;

		size++;
	}

	@Override
	public void remove(T element) {
		if (!contains(element)) {
			throw new IllegalStateException("The element is not in the set.");
		}
		if (element == null) {
			hasANullElement = false;
		} else {
			int k = 0;
			for (int i = 0; i < size; i++) {
				if (element.equals(set[i])) {
					k = i;
				}
			}
			for (int i = k; i < size - 1; i++) {
				set[i] = set[i + 1];
			}
			size--;
		}
	}

	@Override
	public boolean contains(T elemnt) {
		if (elemnt == null) {
			if (hasANullElement) {
				return true;
			}
		} else {
			for (int i = 0; i < size(); i++) {
				if (elemnt.equals(set[i]))
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {

		return size() == 0;
	}

	@Override
	public int size() {
		int size1 = size + 1;
		if (hasANullElement)
			return size1;
		return size;
	}

	@Override
	public boolean isSubset(SetADT<T> set) {

		for (int i = 0; i < size(); i++) {
			if (!set.contains(this.set[i])) {
				return false;
			}
		}
		return true;

	}

	@Override
	public SetADT<T> intersection(SetADT<T> set) {
		SetADT<T> intersectionSet = new BoundedArraySet();

		for (int i = 0; i < size(); i++) {
			if (set.contains(this.set[i])) {
				intersectionSet.add(this.set[i]);
			}
		}
		if (hasANullElement && set.contains(null)) {
			intersectionSet.add(null);
		}
		return intersectionSet;
	}

	@Override
	public SetADT<T> union(SetADT<T> set) {
		SetADT<T> unionSet = new BoundedArraySet<T>();
		Iterator<T> iterator = this.iterator();
		while (iterator.hasNext()) {
			unionSet.add(iterator.next());
		}
		iterator = set.iterator();
		while (iterator.hasNext()) {
			unionSet.add(iterator.next());
		}
		if (hasANullElement || set.contains(null)) {
			unionSet.add(null);
		}
		return unionSet;
	}

	private class BoundedArraySetIterator implements Iterator<T> {
		private int currentIndex;

		public BoundedArraySetIterator() {
			currentIndex =0 ;
		}

		@Override
		public boolean hasNext() {
			return set[currentIndex] != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T element = set[currentIndex];
			currentIndex++;
			return element;
		}
	}

}
