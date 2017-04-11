package module6;

/**
 * Created by Igor on 11.04.2017.
 */
public class CitizenFactory {


    private CitizenFactory() {
    }

    public static Citizen getCitizen(Citizen.CitizenType citizenType) {
        Citizen citizen;
        switch (citizenType) {
            case ENGLISHMAN:
                citizen = new Englishman();
                break;
            case CHINESE:
                citizen = new Chinese();
                break;
            case RUSSIAN:
                citizen = new Russian();
                break;
            case ITALIAN:
                citizen = new Italian();
                break;
            default:
                citizen = null;
                break;
        }

        return citizen;
    }

    private static class Englishman implements Citizen {

        @Override
        public void sayHello() {
            System.out.println("Hello from " + this.getClass().getSimpleName());
        }
    }

    private static class Chinese implements Citizen {

        @Override
        public void sayHello() {
            System.out.println("Hello from " + this.getClass().getSimpleName());
        }
    }

    private static class Russian implements Citizen {

        @Override
        public void sayHello() {
            System.out.println("Hello from " + this.getClass().getSimpleName());
        }
    }

    private static class Italian implements Citizen {

        @Override
        public void sayHello() {
            System.out.println("Hello from " + this.getClass().getSimpleName());
        }
    }
}
