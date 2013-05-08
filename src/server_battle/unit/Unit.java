package server_battle.unit;
import java.util.concurrent.atomic.AtomicInteger;

import server_battle.Position;


public abstract class Unit {
	private static final AtomicInteger uniqueIdCounter = new AtomicInteger();
	
	// unique id
	public final int uniqueId;
	// location
	public Position unitPosition;
	// selection
	public abstract Unit select();
	
	
	public Unit ()	{
		uniqueId = uniqueIdCounter.getAndIncrement();
		
	}
	
}