package threadWorkers;

import Frame.ChangeData;

public abstract class ThreadTask implements Runnable{
	private long ID;
	protected String name;
	private ChangeData status;
	public void run() {
		setStatus(ChangeData.active);
		doTask();
		setStatus(ChangeData.completed);
	}
	public abstract void doTask();
	
	public long getID() {
		return ID;
	}
	public void setID(long id) {
		ID = id;
	}
	public String getName() {
		return name;
	}
	public ChangeData getStatus() {
		return status;
	}
	public void setStatus(ChangeData status) {
		this.status = status;
	}

}
