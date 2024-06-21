package threadWorkers;

import java.util.concurrent.ConcurrentLinkedQueue;

import Frame.ChangeData;
import Frame.ShowStatus;
import Utils.Utils;

public class ThreadWorker extends Thread{
	
	ConcurrentLinkedQueue<ThreadTask> queue;
	private int threadID;
	public ThreadWorker(int ID,ConcurrentLinkedQueue<ThreadTask> MyQueue) {
		threadID = ID;
		queue = MyQueue;
		setDaemon(true);
		setName("ThreadWorker #"+threadID);
	}
	public int getID() {
		return threadID;
	}
	
	@Override
	public void run() {
		ThreadTask task;
		while(true) {
			try {
				synchronized (queue) {
					task = queue.poll();
					if(task == null) {
						queue.wait();
					}
				}
					if(task!=null) {
						task.setID(getID());
						task.run();
					}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

}
