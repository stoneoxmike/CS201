public class ArrayList<E> {
	private static final int INITIAL_CAPACITY = 4;

	private E[] storage;
	private int numElements;

	public ArrayList() {
		this(INITIAL_CAPACITY);
	}

	public ArrayList(int capacity) {
		this.storage = (E[]) new Object[capacity];
		this.numElements = 0;
	}

	public int size() {
		return numElements;
	}

	public void add(E value) {
		if (numElements >= storage.length) {
			grow();
		}
		storage[numElements] = value;
		numElements++;
	}

	public E get(int index) {
		if (index < 0 || index >= numElements) {
			throw new IndexOutOfBoundsException();
		}
		return storage[index];
	}

	public void set(int index, E value) {
		if (index < 0 || index >= numElements) {
			throw new IndexOutOfBoundsException();
		}
		storage[index] = value;
	}

	public E remove(int index) {
		E value = get(index);
		for (int i = index + 1; i < size(); i++) {
			set(i - 1, get(i));
		}
		System.arraycopy(storage, index+1, storage, index, (numElements-index) - 1);
		numElements--;
		return value;
	}

	private void grow() {
		E[] larger = (E[]) new Object[numElements * 2];
		for (int i = 0; i < storage.length; i++) {
			larger[i] = storage[i];
		}
		storage = larger;
	}
}
