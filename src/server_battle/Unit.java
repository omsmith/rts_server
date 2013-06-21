package server_battle;

import java.util.concurrent.atomic.AtomicInteger;

import server_battle.Unit;

public abstract class Unit {
	private static final AtomicInteger uniqueIdCounter = new AtomicInteger();
	
	// unique id
	public final int uniqueId;
	protected final ToDoQueue toDoQueue;
	protected long updateOrder;
	
	
	public Unit (ToDoQueue toDoQueue)	{
		uniqueId = uniqueIdCounter.getAndIncrement();
		this.toDoQueue = toDoQueue;
	}
	
}