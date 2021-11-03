import java.util.Comparator;

public class AlgorithmComparator<E extends Comparable<E>> implements Comparator<E> {

    public AlgorithmComparator() {

    }

    @Override
    public int compare(E o1, E o2) {
        return o1.compareTo(o2);
    }
}
