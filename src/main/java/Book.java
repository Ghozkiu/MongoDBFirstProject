import java.util.Calendar;
import java.util.Date;

public class Book {
    private String bookID;
    private Date dueDate;

    public Book(String bookID, Date dueDate) {
        this.bookID = bookID;
        this.dueDate = dueDate;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
