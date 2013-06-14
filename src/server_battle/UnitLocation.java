package server_battle;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Set;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class UnitLocation {

	public static final String indexName = "geospatialIdx";
	public static final String dbName = "units_geospatial";
	public static final String host = "127.0.0.1";
	public static final int port = 27017;
	public static final String collectionName = "places";
	Mongo mongo;
	DB db;
	DBCollection units;
	
	UnitLocation()	{
		MongoClient mongoClient;
		try {
			mongoClient = new MongoClient("localhost");
			db = mongoClient.getDB( "dbName" );
			units = db.getCollection("unit_position");
			//this.AddUnit(new AtomicInteger(), new Position(0, 0)); // puts a test unit at the origin
			BasicDBObject index = new BasicDBObject();
			index.put("loc","2d");
			units.ensureIndex(index); // indexes as geospatialIdx
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	// adds unit to map, should be functional
	void AddUnit(final AtomicInteger uniqueID, Position unitPosition) {
		BasicDBObject unit = new BasicDBObject("name", "MongoDB");
		unit.put("uniqueID", uniqueID);
		BasicDBObject loc = new BasicDBObject();
		loc.put ("x", unitPosition.getx());
		loc.put("y", unitPosition.gety());
		unit.put("loc", loc);
		units.insert(unit);
	}
	
	// update unit location on map, TODO
	void MoveUnit(final AtomicInteger uniqueID, Position newPosition) {
		BasicDBObject query = new BasicDBObject("uniqueID", uniqueID);
		BasicDBObject update = new BasicDBObject();

		units.update(query, update);
	
	}
	
	// get unit by unique id, should be functional
	void GetUnit(final AtomicInteger uniqueID)	{
		BasicDBObject query = new BasicDBObject("uniqueID", uniqueID);
		DBCursor cursor = units.find(query);
		
		try {
			while(cursor.hasNext()) {
				DBObject result = cursor.next();
				System.out.println(result); // for testing
				
			}
		} finally {
			   cursor.close();
		}
	}
	
	
	ArrayList<AtomicInteger> FindUnitsNear(Position unitPosition)	{ // should be functional, TODO: by default returns nearest 50 units, will update 
		BasicDBObject query = new BasicDBObject("$near", new double[] {unitPosition.getx(), unitPosition.gety()});
		DBCursor cursor = units.find(query);
		ArrayList<AtomicInteger> unitList = new ArrayList<AtomicInteger>();
		try {
		while(cursor.hasNext()) {
			DBObject result = cursor.next();
			System.out.println(result);
			unitList.add((AtomicInteger) result.get("uniqueId"));
	   }
		} finally {
		   cursor.close();
		}
		return unitList;
	}
	
	// removes unit from map
	void Destroy() {
		// TODO
	}
	
}
