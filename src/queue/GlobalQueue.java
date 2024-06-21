package queue;

import java.util.ArrayList;

import threadWorkers.ThreadTask;

public class GlobalQueue {
	
	private static GlobalQueue queue;
	private ArrayList<ThreadTask> elements = new ArrayList<ThreadTask>();
	
	private GlobalQueue() {};
	
	public static GlobalQueue getInstance() {
		if(queue == null)
			queue = new GlobalQueue();
		return queue;
	}
	////////////////////////////////////////////////////////
	public int  getSize() {
		return elements.size();
	}
	public boolean isEmpty() {
		return (elements.size() == 0);
	}
	
	public void add(ThreadTask e) {
		elements.add(e);
	}
	public ThreadTask remove() {
		ThreadTask tmp = elements.remove(0);
		return tmp;
	}
}
