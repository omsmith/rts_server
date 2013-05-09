package server_battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ToDoQueue {
	long startTime = System.nanoTime();
	private List<Activity> toDoQueue = new ArrayList<Activity>();
	
	public Integer add(Activity activity){
		Integer index = 0; 
		Integer process_ID = 0;
		index = Collections.binarySearch(this.toDoQueue, activity, byRequestedExecutionTime);
		if(index < 0)
			index = ~index;
		else
			return null;
		toDoQueue.add(index, activity);
		return process_ID;
	}
	public boolean remove(){
		return true;
	}
	public boolean modify(){
		return true;
	}
	
	final Comparator<Activity> byRequestedExecutionTime = new Comparator<Activity>() {
		public int compare(Activity a1, Activity a2) {
			long temp = a1.getRequestedExecutionTime() - a2.getRequestedExecutionTime();
			if(temp > 0)
				return 1;
			else if (temp == 0)
				return 0;
			else
				return -1;
		}
	};
}
