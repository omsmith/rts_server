package server_battle;


public class Activity {
	private final long requestedExecutionTime;
	private final long process_ID;
	
	
	public Activity(long RequestedExecutionTime, long Process_ID){
		this.process_ID = Process_ID;
		this.requestedExecutionTime = RequestedExecutionTime;
	}
	
	public long getRequestedExecutionTime(){
		return requestedExecutionTime;
	}
	public long getProcess_ID(){
		return process_ID;
	}
}
