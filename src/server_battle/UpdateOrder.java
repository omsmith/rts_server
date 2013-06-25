package server_battle;

import units.Unit;

public class UpdateOrder extends Order{
private final Unit unit;

public UpdateOrder(Unit Unit, long time){
	super(time);
	this.unit = Unit;
}

public Activity update(){
	unit.update();
	if(unit.isupdaterequired()){
		return new Activity(1,this.getOrder_ID(),"Update");
	}else return null;
}
}
