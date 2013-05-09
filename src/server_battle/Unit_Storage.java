package server_battle;

import java.util.ArrayList;
import java.util.List;

public class Unit_Storage {
	private List<Unit> unit_List = new ArrayList<Unit>();
	
	public boolean add(Unit unit){
		unit_List.add(unit);
		return true;
	}
	public boolean remove(Unit unit){
		unit_List.remove(unit);
		return true;
	}
	public Unit getUnit(Integer Unique_ID){
		for(Unit unit : unit_List)
			if(unit.getUnique_ID() == Unique_ID)
				return unit;
		return null;
	}
}
