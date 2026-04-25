package is.hi.hbv202g.assignment8;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class FacultyMemberTest {
    @Test
    public void shouldBePossibleToInstantiateFacultyMember() {
        FacultyMember facultyMember = new FacultyMember("John Computer", "Computer Science");
        assertEquals("John Computer", facultyMember.getName());
        assertEquals("Computer Science", facultyMember.getDepartment());
    }
}
