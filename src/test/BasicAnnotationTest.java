import org.junit.jupiter.api.*;


public class BasicAnnotationTest {
    private static String theTestItem;

    // Run once, e.g. Database connection, connection pool
    @BeforeAll
    public static void runOnceBeforeClass() {
        theTestItem = "item";
        System.out.println("@BeforeAll - initializing DB connection");
    }

    // Run once, e.g close connection, cleanup
    @AfterAll
    public static void runOnceAfterClass() {
        System.out.println("@AfterAll - closing DB connection");
    }

    // Creating a similar object and share for all @Test
    @BeforeEach
    public void runBeforeTestMethod() {
        System.out.println("@BeforeEach - creating a new test table with super exciting data");
    }

    @AfterEach
    public void runAfterTestMethod() {
        System.out.println("@AfterEach - deleting the test table");
    }

    @Test
    public void test_method_1() {
        System.out.println("@Test - test_method_1: querying 1 item from the DB: " + theTestItem);
    }

    @Test
    public void test_method_2() {
        System.out.println("@Test - test_method_2: deleting 1 item from the DB: " + theTestItem);
    }

}