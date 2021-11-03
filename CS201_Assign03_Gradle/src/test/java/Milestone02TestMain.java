import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class Milestone02TestMain {
	private static final class TestListener extends RunListener {
		public volatile String testClassName;
		public ConcurrentHashMap<String, Boolean> resultMap = new ConcurrentHashMap<String, Boolean>();

		@Override
		public void testStarted(Description description) throws Exception {
			resultMap.put(descToName(description), true);
		}

		@Override
		public void testFailure(Failure failure) throws Exception {
			resultMap.put(descToName(failure.getDescription()), false);
		}

		@Override
		public void testFinished(Description description) throws Exception {
			String name = descToName(description);
//			System.out.println(name + "," + resultMap.get(name));
		}

		private String descToName(Description d) {
			String s = d.toString();
			return testClassName + ":" + s.substring(0, s.indexOf('('));
		}
	}

	public static void main(String[] args) {
		final TestListener listener = new TestListener();

		JUnitCore runner = new JUnitCore() {
			@Override
			public Result run(Class<?>... classes) {
				if (classes.length > 1) {
					throw new IllegalArgumentException("Can only run one test class at a time");
				}
				listener.testClassName = classes[0].getSimpleName();
				return super.run(classes);
			}
		};
		
		runner.addListener(listener);
		
		runner.run(KlondikeControllerTest.class);
		
		// print some blank lines in case the tests produced some output
		System.out.print("\n\n\n\n");
		
		ArrayList<String> keys = new ArrayList<String>(listener.resultMap.keySet());
		Collections.sort(keys);
		
//		for (Map.Entry<String, Boolean> entry : listener.resultMap.entrySet()) {
//			System.out.println(entry.getKey() + "," + entry.getValue());
//		}
		for (String k : keys) {
			System.out.println(k + "," + listener.resultMap.get(k));
		}
	}
}
