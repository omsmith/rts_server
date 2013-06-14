package server_battle;

public abstract class Order {
private long Order_ID;

public Order(){}

public long getOrder_ID(){
	return Order_ID;
}

public void update(){
	
}

public void setOrder_ID(long order_ID){
	Order_ID = order_ID;
}
}