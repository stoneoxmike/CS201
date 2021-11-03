import java.util.Comparator;

public class FlipComparator<E> implements Comparator<E> {
    private Comparator<E> comp;
    public FlipComparator(Comparator<E> comp) {
        this.comp = comp;
    }

    @Override
    public int compare(E o1, E o2) {
        return -1*comp.compare(o1, o2);
    }
}
