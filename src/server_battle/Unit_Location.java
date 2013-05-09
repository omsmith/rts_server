package server_battle;

import java.util.ArrayList;
import java.util.List;

public class Unit_Location {
	private List<Unit_Element> unit_List = new ArrayList<Unit_Element>();
	private final Integer paramsust = 100;
	
	public ArrayList<Unit_Element> Box_Selection(Position Top_Left, Position Bottom_Right){
		ArrayList<Unit_Element> Units_Within_Range = new ArrayList<Unit_Element>();
		
		for (Unit_Element unit : unit_List)
			if(unit.getPosn().getx() > Top_Left.getx() && unit.getPosn().getx() < Bottom_Right.getx() &&
			   unit.getPosn().gety() < Top_Left.gety() && unit.getPosn().gety() > Bottom_Right.gety())
				Units_Within_Range.add(unit);
		
		return Units_Within_Range;
	}
	
	public Unit_Element Single_Selection(Position Click){
		ArrayList<Unit_Element> Units_Within_Range = new ArrayList<Unit_Element>();
		
		for (Unit_Element unit : unit_List)
			if(unit.getPosn().getx() > Click.getx() - paramsust && unit.getPosn().getx() < Click.getx() + paramsust &&
			   unit.getPosn().gety() < Click.gety() + paramsust && unit.getPosn().gety() > Click.gety() - paramsust)
				Units_Within_Range.add(unit);
		
		Unit_Element Closest_Unit =  new Unit_Element(new Position(0,0),0);
		Integer Closest_Unit_Distance = Integer.MAX_VALUE;
		Integer TempDistance = 0;
		
		for (Unit_Element unit : Units_Within_Range){
			TempDistance = (int)Math.sqrt(
					Math.pow(unit.getPosn().getx() - Click.getx(),2) +
					Math.pow(unit.getPosn().gety() - Click.gety(),2));
			if(TempDistance < Closest_Unit_Distance){
				Closest_Unit_Distance = TempDistance;
				Closest_Unit = unit;
			}
		}
		
		return Closest_Unit;
	}
	
	public boolean add(Position Posn, Integer Unique_ID){
		Unit_Element addedUnit = new Unit_Element(Posn, Unique_ID);
		return this.unit_List.add(addedUnit);
	}
	public boolean remove(Integer Unique_ID){
		Integer index = 0;
		for(Unit_Element unit:this.unit_List){
			if(unit.getUnique_ID() == Unique_ID){
				this.unit_List.remove(index);
				return true;
			}
			else
				index++;
		}
		return false;
	}
	public boolean move(Position Posn, Integer Unique_ID){
		boolean resultA = this.remove(Unique_ID);
		boolean resultB = this.add(Posn, Unique_ID);
		if(resultA && resultB)
			return true;
		else
			return false;
	}
	
	private class Unit_Element{ 
		private final Position posn; 
		private final Integer unique_ID; 
		public Unit_Element(Position Posn, Integer Unique_ID) { 
			this.posn = Posn; 
			this.unique_ID = Unique_ID; 
		} 

		public Position getPosn() {
			return posn;
		}

		public Integer getUnique_ID() {
			return unique_ID;
		}
	}
}
