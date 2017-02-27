package module4.homework1;

/**
 * Created by Igor on 27.02.2017.
 */
public class ChinaBank extends Bank {

    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    int getLimitOfWithdrawal() {
        int result;
        switch (getCurrency()) {
            case USD:
                result = 100;
                break;
            case EUR:
                result = 150;
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
                result = 5_000;
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
                result = 0;
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
                result = summ < 1000 ? 3 : 5;
                break;
            case EUR:
                result = summ < 1000 ? 10 : 11;
                break;
            default:
                result = 0;
                break;
        }
        return result;

    }
}
