package server_battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Unit_Location{
	Map<Integer,String> unitTable=new HashMap<Integer, String>();
	Unit_SortedList unitPositionTablebyX =new Unit_SortedList('x');
	Unit_SortedList unitPositionTablebyY =new Unit_SortedList('y');
	
	private final Integer paramsust = 100;

	public ArrayList<Unit_Element> Box_Selection(Position Top_Left, Position Bottom_Right){
		ArrayList<Unit_Element> TempX = new ArrayList<Unit_Element>();
		ArrayList<Unit_Element> TempY = new ArrayList<Unit_Element>();
		ArrayList<Unit_Element> Units_Under_Box = new ArrayList<Unit_Element>();
		TempX = unitPositionTablebyX.SelectWithinBounds(Top_Left.getx(),Bottom_Right.getx());
		TempY = unitPositionTablebyY.SelectWithinBounds(Top_Left.gety(),Bottom_Right.gety());
		for (Unit_Element t : TempX)
			if(TempY.contains(t))
				Units_Under_Box.add(t);
		return Units_Under_Box;
	}
	
	public Unit_Element Single_Selection(Position Click){
		ArrayList<Unit_Element> TempX = new ArrayList<Unit_Element>();
		ArrayList<Unit_Element> TempY = new ArrayList<Unit_Element>();
		ArrayList<Unit_Element> Units_Within_ClickRange = new ArrayList<Unit_Element>();
		Unit_Element Closest_Unit =  new Unit_Element(new Position(0,0),0);
		Integer Closest_Unit_Distance = Integer.MAX_VALUE;
		Integer TempDistance = 0;
		TempX = unitPositionTablebyX.SelectWithinBounds(Click.getx() - paramsust,Click.getx() + paramsust);
		TempY = unitPositionTablebyY.SelectWithinBounds(Click.gety() - paramsust,Click.gety() + paramsust);
		for (Unit_Element t : TempX)
			if(TempY.contains(t))
				Units_Within_ClickRange.add(t);
		for (Unit_Element t : Units_Within_ClickRange){
			TempDistance = (int)Math.sqrt(
					Math.pow(t.getPosn().getx() - Click.getx(),2) +
					Math.pow(t.getPosn().gety() - Click.gety(),2));
			if(TempDistance < Closest_Unit_Distance){
				Closest_Unit_Distance = TempDistance;
				Closest_Unit = t;
			}
		}
		
		return Closest_Unit;
	}
	
	class Unit_SortedList{
		private List<Unit_Element> unit_List = new ArrayList<Unit_Element>();
		private Character xory;


		
		public Unit_SortedList(Character XorY){
			if(XorY == 'x' || XorY == 'X')
				xory = 'x';
			else if(XorY == 'y' || XorY == 'Y')
				xory = 'y';
		}

		final Comparator<Unit_Element> byX = new Comparator<Unit_Element>() {
			public int compare(Unit_Element u1, Unit_Element u2) {
				return u1.getPosn().getx() - u2.getPosn().getx();
			}
		};

		final Comparator<Unit_Element> byY = new Comparator<Unit_Element>() {
			public int compare(Unit_Element u1, Unit_Element u2) {
				return u1.getPosn().gety() - u2.getPosn().gety();
			}
		};

		public ArrayList<Unit_Element> SelectWithinBounds(Integer Lower_Bound, Integer Upper_Bound){
			ArrayList<Unit_Element> Units_Within_Range = new ArrayList<Unit_Element>();
			
			if(xory == 'x'){
				for (Unit_Element t : unit_List)
					if(t.posn.getx() > Lower_Bound && t.posn.getx() < Upper_Bound)
						Units_Within_Range.add(t);
			}
			else{
				for (Unit_Element t : unit_List)
					if(t.posn.gety() > Lower_Bound && t.posn.gety() < Upper_Bound)
						Units_Within_Range.add(t);
			}
			return Units_Within_Range;
		}
		
		public boolean add(Position posn, Integer Unique_ID) {
			Unit_Element addedUnit = new Unit_Element(posn, Unique_ID);
			int index;
			if(xory == 'x')
				index = Collections.binarySearch(this.unit_List, addedUnit, byX);
			else
				index = Collections.binarySearch(this.unit_List, addedUnit, byY);
			if (index < 0) index = ~index;
			this.unit_List.add(index, addedUnit);
			return true;
		}
	}
	
	class Unit_Element{ 
		public final Position posn; 
		public final Integer unique_ID; 
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
