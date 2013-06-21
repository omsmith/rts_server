package server_battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ToDoQueue {
	long startTime = System.currentTimeMillis();
	private List<Order_Lists> orderLists = new ArrayList<Order_Lists>();
	private List<Activity> toDoQueue = new ArrayList<Activity>();
	
	public void add(Activity activity){
		int index;
		index = Collections.binarySearch(this.toDoQueue, activity, byRequestedExecutionTime);
		if(index < 0)
			index = ~index;
		toDoQueue.add(index, activity);
	}
	
	public Activity peek(){
		return toDoQueue.get(0);
	}
	
	public Activity pop(){
		return toDoQueue.remove(0);
	}
	
	public Activity remove(long Activity_ID){
		int index = 0;
		for(Activity activity : toDoQueue){
			if(activity.getProcess_ID() == Activity_ID)
				return toDoQueue.remove(index);
			else
				index++;
		}
		return null;
	}
	
	public void RegisterOrderList(Order_Lists newOrderList){
		orderLists.add(newOrderList);
	}
	public Order_Lists FindOrderList(String order_List){
		for(Order_Lists x: orderLists){
			if(x.getName() == order_List){
				return x;
			}
		}
		return orderLists.get(0);
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
