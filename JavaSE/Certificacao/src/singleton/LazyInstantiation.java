package singleton;

public class LazyInstantiation {
	private static volatile LazyInstantiation instance;

	private LazyInstantiation() {
	}

	public static synchronized LazyInstantiation getInstance() {
		if (instance == null) {
			instance = new LazyInstantiation(); // NOT THREAD-SAFE!
		}
		return instance;
	}
}
