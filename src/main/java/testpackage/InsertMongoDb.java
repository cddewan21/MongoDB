package testpackage;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class InsertMongoDb {
	
	public static void main(String args[])
	{
		
		String connectionString = "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
		
		MongoClient mongoClient = MongoClients.create(connectionString);
	
	
	MongoDatabase database = mongoClient.getDatabase("config");
	
	

    MongoCollection<Document> gradesCollection = database.getCollection("vvvvvv");

	Document student = new Document("_id", new ObjectId());
	student.append("student_id", 10000)
	       .append("class_id", 1d);
	
	gradesCollection.insertOne(student);
	System.out.print("deepak");
	
	
	
	}

}
