package testpackage;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ReadMongoDbDocument {
	
	public static void main(String args[])
	{
		
		String connectionString = "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
		
		MongoClient mongoClient = MongoClients.create(connectionString);
	
	
	MongoDatabase database = mongoClient.getDatabase("config");
	
	

    MongoCollection<Document> gradesCollection = database.getCollection("vvvvvv");
    
    Document student1 = gradesCollection.find(new Document("student_id", 10000)).first();
    
    
    for(String key: student1.keySet())
    {
    	System.out.print("key :" + key + student1.get(key)  );

    }
    
    
	System.out.print("deepak");
	
	
	
	}


}
