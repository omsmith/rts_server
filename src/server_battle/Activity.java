package server_battle;


public class Activity {
	private final long requestedExecutionTime;
	private final long process_ID;
	private final Order_Lists order_Lists;
	
	
	public Activity(long RequestedExecutionTime, long Process_ID, Order_Lists order_Lists){
		this.process_ID = Process_ID;
		this.requestedExecutionTime = RequestedExecutionTime;
		this.order_Lists = order_Lists;
	}
	
	public long getRequestedExecutionTime(){
		return requestedExecutionTime;
	}
	public Order_Lists getOrder_Lists(){
		return order_Lists;
	}
	public long getProcess_ID(){
		return process_ID;
	}
}
