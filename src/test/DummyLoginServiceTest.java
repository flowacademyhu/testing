import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DummyLoginServiceTest {
    @Test
    public void testLogin() {
        assertThrows(IllegalArgumentException.class, () -> {
            DummyLoginService dml = new DummyLoginService();
            dml.Login("", "");
        });
    }

    @Test
    public void testLogin2() {
        DummyLoginService dml = new DummyLoginService();
        try {
            dml.Login("dsds", "");
        }
        catch (IllegalArgumentException e) {
            assertEquals("password should not be empty!", e.getMessage());
        }
    }
}