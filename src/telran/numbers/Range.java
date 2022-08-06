package telran.numbers;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Range implements Iterable<Integer> {

	// closed range
	private int min; // inclusive
	private int max; // inclusive
	private Predicate<Integer> predicate = null;


	public Predicate<Integer> getPredicate() {
		return predicate;
	}

	public void setPredicate(Predicate<Integer> predicate) {

		this.predicate = predicate;
	}

	private class RangeIterator implements Iterator<Integer> {
		boolean predicateChecked = false;
		// If predicate == null all range numbers should be iterated
		int currentPosition = min;
		int temp;

		@Override
		public boolean hasNext() {
			if (!predicateChecked) {
				predicateChecked = true;
				if (predicate == null) {
					predicate = new TruePredicate();
				}
			}
			return getMatchingElement(currentPosition) <= max;
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			currentPosition = temp + 1;
			return temp;
		}

		private int getMatchingElement(int tempIndex) {

			if (currentPosition == min) {
				temp = getFirstMatch();
				return temp;
			}
			temp = getAnotherMatch(currentPosition);
			return temp;
		}

		private int getFirstMatch() {
			for (int i = min; i <= max; i++) {
				if (predicate.test(i)) {
					return i;
				}
			}
			return max + 1;
		}

		private int getAnotherMatch(int cp) {
			for (; cp <= max; cp++) {
				if (predicate.test(cp)) {
					return cp;
				}
			}
			return max + 1;
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
