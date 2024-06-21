package threads;

import threadWorkers.ThreadTask;

public class ThreadMult extends ThreadTask{
	
	public ThreadMult() {
		name = "multer";
	}
	@Override
	public void doTask() {
		int a = 10;
		int b = 90;
		long number = a+(long)(Math.random()*b);
		System.out.println(number+ " " +Thread.currentThread().getName());
		
	}

}
