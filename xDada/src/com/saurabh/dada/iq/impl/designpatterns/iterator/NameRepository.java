package com.saurabh.dada.iq.impl.designpatterns.iterator;

public class NameRepository<T> implements Container {
	public String names[] =  { "Priyanka", "Saurabh", "Ashish", "Yasir" };

	@Override
	public Iterator<T> getIterator() {
		return new NameIterator();
	}

	private class NameIterator implements Iterator<T> {

		int index;

		@Override
		public boolean hasNext() {

			if (index < names.length) {
				return true;
			}
			return false;
		}

		@Override
		public T next() {

			if (this.hasNext()) {
				return (T) names[index++];
			}
			return null;
		}
	}
}
