package racingcar;

public class Application {
    public static void main(String[] args) {
        try {
            new Race();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
