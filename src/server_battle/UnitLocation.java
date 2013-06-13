package server_battle;

import java.io.IOException;
import java.net.UnknownHostException;
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

public class UnitLocation {

	public static final String indexName = "geospatialIdx";
	public static final String dbName = "units_geospatial";
	public static final String host = "127.0.0.1";
	public static final int port = 27017;
	public static final String collectionName = "places";
	Mongo mongo;
	DBCollection coll;
	
	void Init()	{
		MongoClient mongoClient;
		try {
			mongoClient = new MongoClient("localhost");
			DB db = mongoClient.getDB( "dbName" );
		
			coll = db.getCollection("unit_position");
			coll.ensureIndex(new BasicDBObject("loc", "2d"), indexName);
			    
			BasicDBObject doc = new BasicDBObject("name", "MongoDB").
	                append("type", "database").
	                append("count", 1).
	                append("info", new BasicDBObject("x", 203).append("y", 102));

			coll.insert(doc);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	// adds unit to map
	void AddUnit() {
		
	}
	
	// update unit location on map
	void UpdateUnit() {

	}
	
	// reads units at a given location/area 
	void ReadUnits()	{
		
	}
	
	// removes unit from map
	void Destroy() {
		
	}
	
}
