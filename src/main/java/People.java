import java.util.List;

public class People extends Address {
    private String ID;
    private String name;



    private List<Integer> books;

    public People(String ID, String name, String street, String city, String state, String zip, List<Integer> books) {
        super(street, city, state, zip);
        this.ID = ID;
        this.name = name;
        this.books = books;

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "People{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getBooks() {
        return books;
    }

    public void setBooks(List<Integer> books) {
        this.books = books;
    }
}
