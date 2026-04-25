package is.hi.hbv202g.assignment8;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class AuthorTest {
    @Test
    public void shouldBePossibleToInstantiateAuthor() {
        Author author = new Author("Aurora");
        assertEquals("Aurora", author.getName());
    }

    @Test
    public void shouldBePossibleToSetAuthorName() {
        Author author = new Author("J.K. Rowling");
        author.setName("George Orwell");
        assertEquals("George Orwell", author.getName());
    }
}
