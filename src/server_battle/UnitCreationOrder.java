package server_battle;

import units.Unit;

public class UnitCreationOrder extends Order{
	private Unit Unit;
	private Position Position;
	private int currentbuildtime;
	
	public UnitCreationOrder(Unit unit, Position position/*,Player player*/){
		super(unit.getbuildTime() > 1 ? 1 : unit.getbuildTime());
		this.Unit = unit;
		this.Position = position;
	}
	private int timeLeftToBuild(){
		return Unit.buildTime - currentbuildtime;
	}
	public Activity update(){
		currentbuildtime += 1;
		int x = timeLeftToBuild();
		Activity updateactivity = null;
		if(x > 1){
			updateactivity = new Activity(1000,this.getOrder_ID(),"Creation");
		}else if (x > 0){
			updateactivity = new Activity(x,this.getOrder_ID(),"Creation");
		}else{
			//create the unit here, getgameQueue().Database.addUnit(Unit,Position/*,possibleBuildArea*/);
			return null;
		}
		return updateactivity;
	}	
}
