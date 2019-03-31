public class Calculator {
    public double divide (int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("y cannot be 0!");
        }
        return x / y;
    }

    public int multiply (int x, int y) {
        if (x > 999) {
            throw new IllegalArgumentException("x should be less than 1000!");
        }

        return x / y;
    }
}
