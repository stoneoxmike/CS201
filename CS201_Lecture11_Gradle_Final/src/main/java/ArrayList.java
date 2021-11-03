// Type parameterized by E
// E will be replaced by specific class upon instantiation
public class ArrayList<E> {
    private static final int INITIAL_CAPACITY = 4;

    // Only store objects of type E (or subclass)
    private E[] storage;
    private int numElements;

    public ArrayList() {
        this.storage = (E[]) new Object[INITIAL_CAPACITY];
        this.numElements = 0;
    }

    // Can only add elements of type E (or subclasses of E)
    public void add(E elt) {
        if (numElements >= storage.length) {
            grow();
        }
        storage[numElements] = elt;
        numElements++;
    }

    public int size() {
        return numElements;
    }

    // Can only return objects of type E
    public E get(int index) {
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException();
        }
        return storage[index];
    }

    private void grow() {
        E[] larger = (E[]) new Object[numElements * 2];
        for (int i = 0; i < storage.length; i++) {
            larger[i] = storage[i];
        }
        storage = larger;
    }
}