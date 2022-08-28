package telran.numbers;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Range implements Iterable<Integer> {

	private int min; // inclusive
	private int max; // inclusive

	private class RangeIterator implements Iterator<Integer> {
		Integer current = getNext(min);

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Integer next() {

			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Integer res = current;
			current = getNext(++current);
			return res;
		}

		private Integer getNext(Integer from) {
			return from > max ? null : from;
		}

	}

	public Range(int min, int max) {

		this.min = min;
		this.max = max;
	}

	@Override
	public Iterator<Integer> iterator() {

		return new RangeIterator();
	}

	public int length() {
		return max - min + 1;
	}

}
