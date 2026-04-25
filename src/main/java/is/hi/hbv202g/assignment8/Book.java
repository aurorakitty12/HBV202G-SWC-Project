package is.hi.hbv202g.assignment8;

public class Book {
    private String title;
    private String author;
    private boolean available;

    public Book() {}

        //Book constructor; takes in title, author, and availability status as parameters
        public Book(String title, String author, boolean available) {
        this.title = title;
        this.author = author;
        this.available = available;
    }
    //getter for book title
    public String getTitle() {
        return title;
    }
    //setter for book title
    public void setTitle(String title) {
        this.title = title;
    }
    //getter for book author
    public String getAuthor() {
        return author;
    }
    //setter for book author
    public void setAuthor(String author) {
        this.author = author;
    }
    //getter for book availability status
    public boolean isAvailable() {
        return available;
    }
    //setter for book availability status
    public void setAvailability(boolean available) {
        this.available = available;
    }
}
