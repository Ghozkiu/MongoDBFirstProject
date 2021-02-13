import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class TestMain {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        calendar.add(Calendar.DATE, 10);
        System.out.println("BEFORE SUBS Today is " + calendar.getTime());
        Book book1 = new Book("1111", calendar.getTime());
        calendar.add(Calendar.DATE, -2);
        System.out.println("AFTER SUBS Today is " + calendar.getTime());
        Book book2 = new Book("2222", calendar.getTime());
        Book book3 = new Book("3333", calendar.getTime());

        calendar = Calendar.getInstance();
        System.out.println("AFTER NEW INSTANCE Today is " + calendar.getTime());
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        for (Book book:
             books) {
            if(book.getDueDate().getDay() == (calendar.getTime().getDay())){
                System.out.println("El libro " + book.getBookID() + " debe entregarse hoy");
                continue;
            } else if(book.getDueDate().getTime() < calendar.getTime().getTime() ){
                System.out.println("El  libro  = " + book.getBookID() + " ya ha vencido" + " " + book.getDueDate());
            }
//            System.out.println(book.getBookID() + " " + book.getDueDate());
        }
    }
}
