package module6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 11.04.2017.
 */
public class CitizenMain {
    public static void main(String[] args) {
        List<Citizen> citizens = new ArrayList<>();
        citizens.add(CitizenFactory.getCitizen(Citizen.CitizenType.ENGLISHMAN));
        citizens.add(CitizenFactory.getCitizen(Citizen.CitizenType.CHINESE));
        citizens.add(CitizenFactory.getCitizen(Citizen.CitizenType.ITALIAN));
        citizens.add(CitizenFactory.getCitizen(Citizen.CitizenType.RUSSIAN));

        citizens.forEach(Citizen::sayHello);

    }
}
