public class DummyLoginService {
    public boolean Login (String username, String pw) {
        if (username.isEmpty())
            throw new IllegalArgumentException("username should not be empty!");

        if (pw.isEmpty())
            throw new IllegalArgumentException("password should not be empty!");

        if (username.equals(pw))
            return true;
        else return false;
    }
}
