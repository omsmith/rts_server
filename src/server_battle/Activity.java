package server_battle;

public class Activity {
	private final long requestedExecutionTime;
	private final long addedTime;
	private final Integer process_ID;
	
	public Activity(long RequestedExecutionTime, long AddedTime,Integer Process_ID){
		this.process_ID = Process_ID;
		this.addedTime = AddedTime;
		this.requestedExecutionTime = RequestedExecutionTime;
	}
	
	public long getRequestedExecutionTime(){
		return requestedExecutionTime;
	}
	public long getAddedTime(){
		return addedTime;
	}
	public Integer getProcess_ID(){
		return process_ID;
	}
}
