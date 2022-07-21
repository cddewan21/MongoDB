package testpackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.opencsv.CSVWriter;

public class ReadMongoDbDocument {
	
	public static void populateDataInMap(Map<String, String> m, Set<String> keySet, Document student1) {
		for (String key : student1.keySet()) {
			Object o = student1.get(key);

		
		
			if (o instanceof Document) {

				populateDataInMap(m, ((Document) student1.get(key)).keySet(), student1);

			} else 
				if (o instanceof String)
				{
				
				if (m.get(key) == null) {
					m.put(key, ((String) student1.get(key)));
				}

				else

				{
					m.put(key, ((String) student1.get(key)).concat(","+m.get(key)));

				}

			}
		}

	}
	
	public static void main(String args[])
	{
		
		String connectionString = "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
		
		MongoClient mongoClient = MongoClients.create(connectionString);
	
	
	MongoDatabase database = mongoClient.getDatabase("config");
	
	

    MongoCollection<Document> gradesCollection = database.getCollection("vvvvvv");
    
    Document student1 = gradesCollection.find(new Document("student_id", new String("100001"))).first();
    
    Map <String, String> m=new HashMap<String, String>();
    
    
    populateDataInMap(m,student1.keySet(),student1);
    
    
  
    
    
    
    String outputFile="C://Users/Dell/eclipse-workspace/abc11.csv";
    
    
	System.out.print("deepak");
	try {
		Writer writer=new BufferedWriter(new FileWriter(outputFile));
		
		CSVWriter csvWriter=new CSVWriter(writer);
		
        List<String> valueList = new ArrayList(m.values());

		
		String[] stringArray = valueList.toArray(new String[0]);

		csvWriter.writeNext( stringArray);
		
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
