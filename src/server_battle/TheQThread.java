package server_battle;

import java.util.concurrent.locks.Lock;

public class TheQThread implements Runnable {
	private ToDoQueue gameQueue;
	Lock l;
	public TheQThread(ToDoQueue gameQueue){
		this.gameQueue = gameQueue;
	}
	public void run(){
		Activity activity;
		for(;;){
			l.lock();
				if(gameQueue.peek().getRequestedExecutionTime() <= System.currentTimeMillis()){
					activity = gameQueue.pop();
				}
				else{
					activity = null;
				}
			l.unlock();
			if(activity != null){
				activity.getOrder_Lists().update(activity.getProcess_ID());
			}
				
				
		}
	}
	
}