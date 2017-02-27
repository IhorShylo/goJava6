package module4.homework1;

/**
 * Created by Igor on 27.02.2017.
 */
public class EUBank extends Bank {

    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    int getLimitOfWithdrawal() {
        int result;
        switch (getCurrency()) {
            case USD:
                result = 2000;
                break;
            case EUR:
                result = 2200;
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
                result = 10_000;
                break;
            case EUR:
                result = 20_000;
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
                result = 0;
                break;
            case EUR:
                result = 1;
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
                result = summ < 1000 ? 2 : 4;
                break;
            default:
                result = 0;
                break;
        }
        return result;

    }
}
