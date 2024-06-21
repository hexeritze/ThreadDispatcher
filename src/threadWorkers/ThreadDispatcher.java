package threadWorkers;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

import Frame.ChangeData;
import Frame.ShowStatus;
import threads.ThreadShow;

public class ThreadDispatcher {
	
	private static ThreadDispatcher dispatcher;
	private ConcurrentLinkedQueue<ThreadTask> myQueue = new ConcurrentLinkedQueue<ThreadTask>();
	private ConcurrentLinkedQueue<ThreadTask> allTask = new ConcurrentLinkedQueue<ThreadTask>();
	private static int size = 1;
	private ThreadDispatcher() {
		this(1);
	}
	private ThreadDispatcher(int size) {
		setPoolSize(size);
		for(var i = 0;i<getPoolSize();i++) {
			new ThreadWorker(i+1, myQueue).start();
		}
		
	}
	public static ThreadDispatcher create() {
		if(getDispatcher() == null) {
			setDispatcher(new ThreadDispatcher());
			dispatcher.add(new ThreadShow(dispatcher));
		}
		return getDispatcher();
	}
	public static ThreadDispatcher create(int size) {
		if(getDispatcher() == null) {
			setDispatcher(new ThreadDispatcher(size));
			dispatcher.add(new ThreadShow(dispatcher));
		}
		return getDispatcher();
	}
	public static ThreadDispatcher getDispatcher() {
		return dispatcher;
	}

	public static void setDispatcher(ThreadDispatcher dispatcher) {
		ThreadDispatcher.dispatcher = dispatcher;
	}

	////////////////////////////////////////////////
	public void add(ThreadTask task) {
		allTask.add(task);
		Thread thread = new Thread(task);
		thread.start();
	}
	
	public void addInQueue(ThreadTask task) {
		allTask.add(task);
		synchronized(myQueue) {
			myQueue.add(task);
			task.setStatus(ChangeData.inQueue);
			myQueue.notify();
		}
	}
	
	public ConcurrentLinkedQueue<ThreadTask> getQueue() {
		return myQueue;
	}
	
	public int getPoolSize() {
		return size;
	}
	public void setPoolSize(int maxSize) {
		size = maxSize;
	}
	
	public ConcurrentLinkedQueue<ThreadTask> getAllTasks() {
		return allTask;
	}
}
