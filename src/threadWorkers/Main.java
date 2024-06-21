package threadWorkers;

import Frame.Window;
import threads.ThreadMult;
import threads.ThreadPrint;
import threads.ThreadShow;

//import panelMonitor.PanelMonitor;

public class Main {

	public static void main(String[] args) {
		
		var proba = ThreadDispatcher.create(50);
		for(var i = 0;i<1000;i++) {
			proba.addInQueue(new ThreadPrint());
		}
	}

}
