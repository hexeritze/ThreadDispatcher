package Frame;

public class ShowStatus {
	private int nameID;
	private String nameTask;
	private ChangeData status;
	public ShowStatus(int ID,String name,ChangeData stat) {
		nameID = ID;
		nameTask = name;
		status = stat;
	}
	public int getNameID() {
		return nameID;
	}
	public String getNameTask() {
		return nameTask;
	}
	public ChangeData getStatus() {
		return status;
	}
	public void setStatus(ChangeData stat) {
		status = stat;
	}
}
