import com.mongodb.client.*;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;

public class MongoDB {

    public static MongoClient mongoClient;
    public static MongoDatabase database;
    public static MongoCollection<People> collection;

    public static void main(String[] args) {


        mongoClient = MongoClients.create(
                "mongodb+srv://admin:passwordadmin@cluster0.rr7hw.mongodb.net/cluster0?retryWrites=true&w=majority");
        database = mongoClient.getDatabase("test");

        List<Integer> books = Arrays.asList(27464, 747854);
        People person = new People("puto", "Jo Bloggs", "123 Fake St", "Faketon", "MA", "12345", books);
        collection = database.getCollection("people", People.class);
        collection.insertOne(person);
//        MongoCursor<People> cursor = collection.find().cursor();
//        while(cursor.hasNext()){
//            System.out.println(cursor);
//        }
    }

    public static Document convert(People object) {
        return new Document("_id", object.getID())
                .append("name", object.getName())
                .append("address", object.getAddress())
                .append("books", object.getBooks());
    }
}
