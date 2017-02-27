package module4.homework1;

/**
 * Created by Igor on 27.02.2017.
 */
public class USBank extends Bank {

    public USBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    int getLimitOfWithdrawal() {
        int result;
        switch (getCurrency()) {
            case USD:
                result = 1000;
                break;
            case EUR:
                result = 1200;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }

    @Override
    int getLimitOfFunding() {
        int result;
        switch (getCurrency()) {
            case USD:
                result = -1;
                break;
            case EUR:
                result = 10000;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }

    @Override
    int getMonthlyRate() {
        int result;
        switch (getCurrency()) {
            case USD:
                result = 1;
                break;
            case EUR:
                result = 2;
                break;
            default:
                result = 0;
                break;
        }
        return result;

    }

    @Override
    int getCommission(int summ) {
        int result;
        switch (getCurrency()) {
            case USD:
                result = summ < 1000 ? 5 : 7;
                break;
            case EUR:
                result = summ < 1000 ? 6 : 8;
                break;
            default:
                result = 0;
                break;
        }
        return result;

    }
}
