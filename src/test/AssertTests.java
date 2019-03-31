import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AssertTests {
    @Test
    public void testAssertArrayEquals() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
        assertArrayEquals(expected, actual, "failure - byte arrays not same");
    }

    @Test
    public void testAssertEquals() {
        assertEquals("failure - strings are not equal", "text", "text");
    }

    @Test
    public void testAssertFalse() {
        assertFalse(false, "failure - should be false");
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull(new Object(), "should not be null");
    }

    @Test
    public void testAssertNotSame() {
        assertNotSame(new Object(), new Object(), "should not be same Object");
    }

    @Test
    public void testAssertNull() {
        assertNull(null, "should be null");
    }

    @Test
    public void testAssertSame() {
        Integer aNumber = Integer.valueOf(768);
        assertSame(aNumber, aNumber, "should be same");
    }

    @Test
    public void testAssertTrue() {
        assertTrue(true, "failure - should be true");
    }
}