package server_battle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Order_Lists {
protected static AtomicLong Unique_Order_ID = new AtomicLong();
protected List<Order> Outstanding_Orders = new ArrayList<Order>();
protected final ToDoQueue toDoQueue;
protected final String name;


public Order_Lists(ToDoQueue toDoQueue, String name){
	this.toDoQueue = toDoQueue;
	this.name = name;
	toDoQueue.RegisterOrderList(this);
}

public String getName(){
	return name;
}
protected ToDoQueue getToDoQueue(){
	return toDoQueue;
}

public long add(Order order){
	order.setOrder_ID(GetandIncrement());
	Outstanding_Orders.add(order);
	Activity activity = new Activity(order.getfirsttime(),order.getOrder_ID(),getName());
	toDoQueue.add(activity);
	return order.getOrder_ID();
}

public Activity update(long order_ID){
	for(Order x:Outstanding_Orders){
		if(x.getOrder_ID() == order_ID){
			return x.update();
		}
	}
	return null;
}

public Order remove(long order_ID){
	int index = 0;
	for(Order order : Outstanding_Orders){
		if(order.getOrder_ID() == order_ID)
			return Outstanding_Orders.remove(index);
		else
			index++;
	}
	return null;
}

protected synchronized long GetandIncrement(){
	return Unique_Order_ID.getAndIncrement();
}
}
