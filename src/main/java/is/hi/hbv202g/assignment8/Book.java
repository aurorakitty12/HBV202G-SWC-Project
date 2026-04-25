package is.hi.hbv202g.assignment8;

import java.util.ArrayList;

public class Book {
    private String title;
    private ArrayList<Author> authors;
    private boolean available;

    public Book() {}

    public Book(String title, ArrayList<Author> authors, boolean available) {
        this.title = title;
        this.authors = authors;
        this.available = available;
    }

        public Book(String title, String author, boolean available) {
        this.title = title;
        this.authors = new ArrayList<Author>();
        this.authors.add(new Author(author));
        this.available = available;
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
    public Author getAuthor(int index) throws EmptyAuthorListException {
        if (authors == null || authors.isEmpty()) {
            throw new EmptyAuthorListException("Author list is empty");
        }
        if (index < 0 || index >= authors.size()) {
            throw new IndexOutOfBoundsException("Author index out of bounds");
        }
        return authors.get(index);
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
