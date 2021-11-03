import java.util.Comparator;

public class SumIntFunctor implements Functor<Integer> {
	// TODO: field(s)
	int sum;
	public SumIntFunctor() {
		// TODO: initialize field(s)
		sum = 0;
	}
	
	@Override
	public void apply(Integer value) {
		sum = sum + value;
	}
	
	/**
	 * @return the sum of all Integer values seen by this functor
	 */
	public int getSum() {
		return sum;
	}
}

