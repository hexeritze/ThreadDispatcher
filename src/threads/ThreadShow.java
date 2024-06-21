package threads;

import java.util.concurrent.ConcurrentLinkedQueue;

import Frame.ChangeData;
import Frame.Window;
import threadWorkers.ThreadDispatcher;
import threadWorkers.ThreadTask;
import threadWorkers.ThreadWorker;

public class ThreadShow extends ThreadTask{
	public ConcurrentLinkedQueue<ThreadTask> allTask;
	public ConcurrentLinkedQueue<ThreadTask> tasks;
	
	private Window window;
	public ThreadShow(ThreadDispatcher dispatcher) {
		allTask = dispatcher.getAllTasks();
		tasks = dispatcher.getQueue();
		name = "monitor";
		window = new Window();
	}
	@Override
	public void doTask() {
		while(true) {
			reShow();
		}
		
	}
	private void reShow() {
		var text = new StringBuffer();
		text.append("----------------------------------------------------------------\n");
		text.append(String.format("%-30s", "TASK")+String.format("%-30s", "STATUS")+String.format("%-8s", "ID")+"\n");
		text.append("----------------------------------------------------------------\n");
		for(var e : allTask) {
			if(e.getStatus().equals(ChangeData.active)) {
				text.append(String.format("%-30s", e.getName()));
				text.append(String.format("%-30s", ChangeData.active));
				text.append(String.format("%-30s", e.getID()));
				text.append("\n");
			}
			
		}
		for(var e : allTask) {
			if(e.getStatus().equals(ChangeData.inQueue)) {
				text.append(String.format("%-30s", e.getName()));
				text.append(String.format("%-30s", ChangeData.inQueue));
				text.append("\n");
			}
			
		}
		text.append("-----------------------Completed--------------------------\n");
		for(var e : allTask) {
			if(e.getStatus().equals(ChangeData.completed)) {
				text.append(String.format("%-30s", e.getName()));
				text.append(String.format("%-30s", ChangeData.completed));
				text.append("\n");
			}
			
		}
		window.changeText(text.toString());
	}

}
