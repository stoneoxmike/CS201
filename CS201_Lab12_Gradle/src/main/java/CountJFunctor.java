public class CountJFunctor implements Functor<String> {
	// TODO: field(s)
	int JCount;
	public CountJFunctor() {
		// TODO: initialize field(s)
		JCount = 0;
	}

	@Override
	public void apply(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (Character.toLowerCase(value.charAt(i)) == 'j') {
				JCount++;
			}
		}
	}

	/**
	 * @return the total number of 'J' or 'j' characters contained
	 *         in all of the String values seen by this functor
	 */
	public int getJCount() {
		return JCount;
	}

}
