
public class singletonExample {

	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
			System.out.println("thread start: " + i);
			(new testingThread()).start();
		}
	}
}

/*
 * Thread implementation that get an instance of Singleton, 
 * increment it and print it.
 */
class testingThread extends Thread {
	@Override
	public void run() {
		Singleton.getInstance().incrementData();
		System.out.println(Singleton.getInstance().getData());
	}
}

/*
 * Class singleton that encapsulate a int number.
 */
class Singleton {
	private int data;
	static private Singleton instance;
	
	// Private constructor for the singleton.
	private Singleton() {
		data = 0;
	}
	
	// Return the instance of Singleton
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}
	
	// getter for {@code data};
	public int getData() {
		return instance.data;
	}
	
	// increment the value of {@code data}
	public void incrementData() {
		synchronized (Singleton.class) {
			instance.data++;
		}
	}
	
}
