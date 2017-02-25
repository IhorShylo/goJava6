package module3.homework4;

/**
 * Created by Igor on 25.02.2017.
 */
public class User {
    private String name;
    private int balance;
    private int monthsOfEmployment;
    private String companyName;
    private int salary;
    private String currency;

    public User(String name, int balance, int monthsOfEmployment, String companyName, int salary, String currency) {
        this.name = name;
        this.balance = balance;
        this.monthsOfEmployment = monthsOfEmployment;
        this.companyName = companyName;
        this.salary = salary;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMonthsOfEmployment() {
        return monthsOfEmployment;
    }

    public void setMonthsOfEmployment(int monthsOfEmployment) {
        this.monthsOfEmployment = monthsOfEmployment;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void paySalary() {
        this.balance += this.salary;
    }

    public void withdraw(int sum) {
        if (sum < 0) {
            System.out.println("Can't be negative");
        } else if (sum > 0 && sum < 1000) {
            this.balance = (int) (this.balance - sum - sum * 0.05);
        } else {
            this.balance = (int) (this.balance - sum - sum * 0.1);
        }

    }

    public int companyNameLength(){
        return this.companyName == null ? 0 : this.companyName.length();
    }

    public void monthIncreaser(int addMonth){
        this.monthsOfEmployment += addMonth;
    }
}
