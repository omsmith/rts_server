package server_battle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Order_Lists {
public static AtomicLong Unique_Queue_ID = new AtomicLong();
private List<Order> Outstanding_Orders = new ArrayList<Order>();

public long add(Order order){
	order.setOrder_ID(GetandIncrement());
	Outstanding_Orders.add(order);
	return order.getOrder_ID();
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

private synchronized long GetandIncrement(){
	return Unique_Queue_ID.getAndIncrement();
}
}
