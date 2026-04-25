package is.hi.hbv202g.assignment8;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    @Test
    public void shouldBePossibleToInstantiateStudent() {
        Student student = new Student("Alice", true);
        assertEquals("Alice", student.getName());
        assertTrue(student.isFeePaid());
    }
}
