import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MongoDB {

    public static MongoClient mongoClient;
    public static MongoDatabase database;
    public static MongoCollection<Document> collection;

    public static void main(String[] args) {

        ConnectionString connectionString = new ConnectionString(
                "mongodb+srv://admin:passwordadmin@cluster0.rr7hw.mongodb.net/cluster0?retryWrites=true&w=majority"
        );

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .retryWrites(true)
                .build();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("test");


        List<Integer> books = Arrays.asList(27464, 747854);
        People person = new People("second person", "Jo second", "123 Fake St", "Faketon", "MA", "12345", books);
        collection = database.getCollection("people", Document.class);
//        collection.insertOne(convert(person));

        FindIterable<Document> docIterator = collection.find();
        Iterator<Document>iterator = docIterator.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getString("name"));
        }
        mongoClient.close();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


        System.out.println("today is " + dateFormat.format(date));



    }

    public static Document convert(People object) {
        return new Document("_id", object.getID())
                .append("name", object.getName())
                .append("address", object.getAddress())
                .append("books", object.getBooks());
    }
}
