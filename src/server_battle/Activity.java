package server_battle;

public abstract class Activity {
	private final long requestedExecutionTime;
	//private final long addedTime;
	private final Integer process_ID;
	private final Integer previousProcess_ID;
	private final Integer nextProcess_ID;
	
	
	public Activity(long RequestedExecutionTime/*, long AddedTime*/, Integer Process_ID
			, Integer PreviousProcess_ID, Integer NextProcess_ID){
		this.process_ID = Process_ID;
		//this.addedTime = AddedTime;
		this.requestedExecutionTime = RequestedExecutionTime;
		this.previousProcess_ID = PreviousProcess_ID;
		this.nextProcess_ID = NextProcess_ID;
	}
	
	public long getRequestedExecutionTime(){
		return requestedExecutionTime;
	}
	public long getnextProcess_ID(){
		return nextProcess_ID;
	}
	public long getpreviousProcess_ID(){
		return previousProcess_ID;
	}
	/*public long getAddedTime(){
		return addedTime;
	}*/
	public Integer getProcess_ID(){
		return process_ID;
	}
}
