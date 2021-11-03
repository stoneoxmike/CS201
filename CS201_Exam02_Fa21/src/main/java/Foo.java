public class Foo implements Comparable<Foo> {
	private int x;
	private Card c;
	
	public Foo(int x, Card c) {
		this.x = x;
		this.c = c;
	}
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Foo )) {
			return false;
		}
		
		Foo f = (Foo) o;
		
		return this.compareTo(f) == 0;
	}
	
	public int compareTo(Foo f) {
		if (this.x < f.x) {
			return -1;
		} else if (this.x > f.x) {
			return 1;
		} else {
			return this.c.compareTo(f.c);
		}
	}

}
