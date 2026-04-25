package is.hi.hbv202g.assignment8;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserOrBookDoesNotExistExceptionTest {
    @Test
    public void shouldThrowUserOrBookDoesNotExistExceptionWhenFindingNonExistentUser() {
        LibrarySystem librarySystem = new LibrarySystem();
        assertThrows(UserOrBookDoesNotExistException.class, () -> {
            librarySystem.findUserByName("John Evil, Who Is Not Welcome In This Library");
        });
    }
}
