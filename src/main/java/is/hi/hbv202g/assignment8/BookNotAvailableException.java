package is.hi.hbv202g.assignment8;

//Exception class for when a book is not available for checkout
public class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
    
}
