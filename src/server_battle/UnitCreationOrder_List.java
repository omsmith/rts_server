package server_battle;

public class UnitCreationOrder_List extends Order_Lists{
	public UnitCreationOrder_List(ToDoQueue toDoQueue){
		super(toDoQueue, "UnitCreation");
	}
	public long add(Order order){
		order.setOrder_ID(GetandIncrement());
		Outstanding_Orders.add(order);
		Activity activity = new Activity(order.getfirsttime(),order.getOrder_ID(),getName());
		toDoQueue.add(activity);
		return order.getOrder_ID();
	}
}
