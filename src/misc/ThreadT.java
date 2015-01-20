package misc;





public class ThreadT implements Runnable {

	public synchronized void run() {
		System.out.println("RUn----------------" + System.nanoTime()+"");
		System.out.println("run.");
		throw new RuntimeException("Problem");
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new ThreadT());
		System.out.println("before ------------"+System.nanoTime()+"");
		t.run();
		Thread.sleep(0,1);
//		t.
		System.out.println("before end---------" + System.nanoTime()+"");
		System.out.println("End of method.");
	}
}