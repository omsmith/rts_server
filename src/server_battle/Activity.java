package server_battle;


public class Activity {
	private final long requestedExecutionTime;
	private final long process_ID;
	private Order_Lists order_Lists;
	private String Order_Type;
	
	public Activity(long RequestedExecutionTime, long Process_ID, String order_Type){
		this.process_ID = Process_ID;
		this.requestedExecutionTime = RequestedExecutionTime;
		this.Order_Type = order_Type;
	}
	
	public String getOrder_Type(){
		return Order_Type;
	}
	public long getRequestedExecutionTime(){
		return requestedExecutionTime;
	}
	public Order_Lists getOrder_Lists(){
		return order_Lists;
	}
	public void setOrder_Lists(Order_Lists listinsert){
		order_Lists = listinsert;
	}
	public long getProcess_ID(){
		return process_ID;
	}
}
