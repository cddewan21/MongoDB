package testpackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.opencsv.CSVWriter;

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
    String outputFile="C://Users/Dell/eclipse-workspace/abc.csv";
    
    
	System.out.print("deepak");
	try {
		Writer writer=new BufferedWriter(new FileWriter(outputFile));
		
		CSVWriter csvWriter=new CSVWriter(writer);
		String[] myStrings = { "deepak1", "deepak2", "deepak3" };
		csvWriter.writeNext( myStrings);
		/*
		 * for(BmcQueMesssage msg: bmcQueMsgs) {
		 * csvWriter.writeNext(detailFunc.apply(msg)); }
		 */
		csvWriter.flush();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	}


}
