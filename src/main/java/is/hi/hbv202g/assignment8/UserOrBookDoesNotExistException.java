package is.hi.hbv202g.assignment8;

public class UserOrBookDoesNotExistException extends Exception {
    //Exception class for when a user or book does not exist in the library system
    public UserOrBookDoesNotExistException(String message) {
        super(message);
    }

}
