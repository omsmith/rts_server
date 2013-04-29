package server_battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Unit_Element{ 
	public final Position posn; 
	public final Integer unique_ID; 
	public Unit_Element(Position Posn, Integer Unique_ID) { 
	  this.posn = Posn; 
	  this.unique_ID = Unique_ID; 
	} 
}

class Unit_SortedList{
	private List<Unit_Element> list = new ArrayList<Unit_Element>();
	
	public Unit_SortedList(){
	}
		
	public boolean add(Position posn, String unit) {
    int index = Collections.binarySearch(this, mt);
    if (index < 0) index = ~index;
    super.add(index, mt);
    return true;
    }
}

public class Unit_Information {
	Map<Integer,String> unitTable=new HashMap<Integer, String>();
	Map<Position,String> unitPositionTable=new HashMap<Position, String>();
}
