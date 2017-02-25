package module3.homework1;

/**
 * Добавить метод sing к классу Bird, потом измените основной метод соответственно, чтобы код вывел следующий текст:
 I am walking
 I am flying
 I am singing
 I am Bird
 */
public class Bird {

    public static void main(String[] args) {
        sing();
    }

    private static void sing() {
        System.out.println("I am walking");
        System.out.println("I am flying");
        System.out.println("I am singing");
        System.out.println("I am Bird");
    }
}
