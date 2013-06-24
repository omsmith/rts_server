package server_battle;

public abstract class Order {
private long Order_ID;
private final long firsttime;


public Order(long Time){
	firsttime = Time;
}
public long getfirsttime(){
	return firsttime;
}
public long getOrder_ID(){
	return Order_ID;
}
public Activity update(){return null;}
public void setOrder_ID(long order_ID){
	Order_ID = order_ID;
}
}