package threads;

import threadWorkers.ThreadTask;

public class ThreadPrint extends ThreadTask{
	public ThreadPrint() {
		name = "printer";
	}
	@Override
	public void doTask() {
		System.out.println("hello from "+Thread.currentThread().getName());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
