package is.hi.hbv202g.assignment8;

import java.util.ArrayList;

public class Book {
    private String title;
    private ArrayList<Author> authors;

    public Book() {}

    public Book(String title, ArrayList<Author> authors) {
        this.title = title;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Author> getAuthors() throws EmptyAuthorListException {
        if (authors == null || authors.isEmpty()) {
            throw new EmptyAuthorListException("Author list is empty");
        }
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        if (authors == null) {
            authors = new ArrayList<Author>();
        }
        authors.add(author);
    }

}
